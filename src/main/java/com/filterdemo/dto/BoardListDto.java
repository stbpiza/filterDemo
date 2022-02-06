package com.filterdemo.dto;

import com.filterdemo.entity.Board;
import com.filterdemo.entity.PostType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardListDto {

    private Long boardId;

    private String title;

    private Long views;

    private LocalDateTime createTime;

    private PostType postType;


    private String nickname;


    private String languageName;


    public BoardListDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.views = board.getViews();
        this.createTime = board.getCreateTime();
        this.postType = board.getPostType();

        this.nickname = board.getUser().getNickname();

        this.languageName = board.getLanguageMappings().get(0).getLanguage().getLanguageName();
    }
}
