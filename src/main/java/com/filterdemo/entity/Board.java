package com.filterdemo.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false, length = 10000)
    private String content;

    @Column(nullable = false, length = 100)
    private String title;

    private Long views;

    private LocalDateTime createTime;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PostType postType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<LanguageMapping> languageMappings = new ArrayList<>();


    public Board(String content, String title, Long views, LocalDateTime createTime, PostType postType, User user) {
        this.content = content;
        this.title = title;
        this.views = views;
        this.createTime = createTime;
        this.postType = postType;
        this.user = user;
    }

    public Board(Long boardId) {
        this.boardId = boardId;
    }
}
