package com.example.multiple.spring.rest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@SpringBootApplication
@ComponentScan("com.example.multiple.spring.rest")
public class SpringBootRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestServiceApplication.class, args);
    }
}
