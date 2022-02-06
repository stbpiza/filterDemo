package com.filterdemo.service;

import com.filterdemo.entity.*;
import com.filterdemo.repository.BoardRepository;
import com.filterdemo.repository.LanguageMappingRepository;
import com.filterdemo.repository.LanguageRepository;
import com.filterdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class GeneratorService {

    private final BoardRepository boardRepository;
    private final LanguageMappingRepository languageMappingRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final EntityManager em;

    Random rd = new Random();

    public void setTestData() {

        rd.nextInt();

        setUserData();

        setLanguageData();

        setBoardData();

        setLanguageMappingData();

    }

    private void setUserData() {

        List<User> userList = new ArrayList<>();

        User user1 = new User("1234", "abc@abc", "sun");
        User user2 = new User("1234", "123@abc123", "jay");
        User user3 = new User("1234", "abcd@abcd", "bin");
        User user4 = new User("1234", "a1@ab1", "gildong");
        User user5 = new User("1234", "a22bc@a2bc", "hong");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        userRepository.saveAll(userList);

    }

    private void setLanguageData() {

        List<Language> languageList = new ArrayList<>();

        Language language1 = new Language("JAVA");
        Language language2 = new Language("JavaScript");
        Language language3 = new Language("Python");

        languageList.add(language1);
        languageList.add(language2);
        languageList.add(language3);

        languageRepository.saveAll(languageList);

    }

    private void setBoardData() {

        List<Board> boardList = new ArrayList<>();

        List<PostType> postTypeList = new ArrayList<>();

        postTypeList.add(PostType.NORMAL);
        postTypeList.add(PostType.NOTICE);
        postTypeList.add(PostType.QUESTION);

        for (int i=1; i<=100; i++) {
            String title = "테스트글입니다" + i;

            boardList.add(new Board("내용입니다", title, (long)rd.nextInt(200), LocalDateTime.now(),
                    postTypeList.get(rd.nextInt(3)), new User((long)rd.nextInt(5)+1)));
        }

        boardRepository.saveAll(boardList);
    }

    private void setLanguageMappingData() {

        List<LanguageMapping> languageMappingList = new ArrayList<>();

        for (int i=1; i<=100; i++) {
            languageMappingList.add(new LanguageMapping(new Language((long)rd.nextInt(3)+1), new Board((long)i)));
        }

        languageMappingRepository.saveAll(languageMappingList);
    }
}
