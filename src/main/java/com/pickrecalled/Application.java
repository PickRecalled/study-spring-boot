package com.pickrecalled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 来标注一个主程序，说明这是一个spring boot应用
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //spring运行主程序
        SpringApplication.run(Application.class, args);
    }
}
