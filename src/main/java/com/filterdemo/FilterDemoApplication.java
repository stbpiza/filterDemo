package com.filterdemo;

import com.filterdemo.service.GeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class FilterDemoApplication implements CommandLineRunner {

    private final GeneratorService generatorService;

    public static void main(String[] args) {
        SpringApplication.run(FilterDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        generatorService.setTestData();
    }
}
