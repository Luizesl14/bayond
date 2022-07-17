package com.dvp.bayond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class BayondApplication {

    public static void main(String[] args) {
        SpringApplication.run(BayondApplication.class, args);
    }

}
