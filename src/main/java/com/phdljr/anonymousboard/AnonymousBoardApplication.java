package com.phdljr.anonymousboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AnonymousBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnonymousBoardApplication.class, args);
    }

}
