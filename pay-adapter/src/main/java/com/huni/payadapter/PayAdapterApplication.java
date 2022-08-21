package com.huni.payadapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.huni.paycore"})
public class PayAdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayAdapterApplication.class, args);
    }

}
