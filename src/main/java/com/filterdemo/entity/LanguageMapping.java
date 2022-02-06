package com.filterdemo.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class LanguageMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageMappingId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageId")
    private Language language;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardId")
    private Board board;

    public LanguageMapping(Language language, Board board) {
        this.language = language;
        this.board = board;
    }
}
