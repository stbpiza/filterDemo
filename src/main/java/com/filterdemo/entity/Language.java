package com.filterdemo.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;


    private String languageName;


    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    private List<LanguageMapping> languageMappings = new ArrayList<>();

    public Language(String languageName) {
        this.languageName = languageName;
    }

    public Language(Long languageId) {
        this.languageId = languageId;
    }
}
