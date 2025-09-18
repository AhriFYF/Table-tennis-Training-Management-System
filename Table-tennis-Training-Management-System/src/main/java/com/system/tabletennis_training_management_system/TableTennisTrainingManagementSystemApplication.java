package com.system.tabletennis_training_management_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.system.tabletennis_training_management_system.mapper") // <-- 加上这个注解
public class TableTennisTrainingManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TableTennisTrainingManagementSystemApplication.class, args);
    }

}
