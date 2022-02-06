package com.filterdemo.repository;

import com.filterdemo.dto.RqBoardListSearchDto;
import com.filterdemo.entity.*;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.filterdemo.entity.QBoard.board;
import static com.filterdemo.entity.QLanguage.language;
import static com.filterdemo.entity.QLanguageMapping.languageMapping;

@Repository
public class BoardQueryRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public BoardQueryRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public List<Board> getBoardList(RqBoardListSearchDto dto) {

        return query
                .selectDistinct(board)
                .from(board)
                .leftJoin(board.user, QUser.user).fetchJoin()
                .leftJoin(board.languageMappings, languageMapping).fetchJoin()
                .leftJoin(languageMapping.language, language).fetchJoin()
                .where(typeEq(dto.getType()), languageEq(dto.getLanguage()))
                .orderBy(getOrder(dto.getOrder()))
                .fetch();

    }

    private BooleanExpression typeEq(PostType type) {
        if (type == null) { return null; }
        return board.postType.eq(type);
    }

    private BooleanExpression languageEq(String languageName) {
        if(languageName == null) { return null; }
        return language.languageName.eq(languageName);
    }

    private OrderSpecifier<?> getOrder(BoardOrderType order) {
        if (order == null) {
            return board.createTime.desc();
        } else if (order.equals(BoardOrderType.LAST)) {
            return board.createTime.asc();
        } else if (order.equals(BoardOrderType.VIEW)) {
            return board.views.desc();
        }

        return board.createTime.desc();
    }

}
