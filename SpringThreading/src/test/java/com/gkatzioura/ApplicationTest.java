package com.gkatzioura;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
class ApplicationTest {

    @Test
    void testSpringThreading() {

        String[] args = {""};

        SpringApplication.run(Application.class, args);
    }
}
