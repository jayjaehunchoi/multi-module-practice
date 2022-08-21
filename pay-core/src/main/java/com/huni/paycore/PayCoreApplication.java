package com.huni.paycore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PayCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayCoreApplication.class, args);
    }

}
