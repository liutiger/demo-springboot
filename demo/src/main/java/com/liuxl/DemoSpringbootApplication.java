package com.liuxl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liuxl.mapper")
public class DemoSpringbootApplication {

    public static void main(String[] args) {
        System.out.println(1+"**********");
        SpringApplication.run(DemoSpringbootApplication.class, args);

    }

}
