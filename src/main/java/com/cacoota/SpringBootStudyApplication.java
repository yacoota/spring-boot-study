package com.cacoota;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@MapperScan("com.cacoota.*.mapper.mybatis")
@EnableTransactionManagement
@EnableScheduling
public class SpringBootStudyApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(SpringBootStudyApplication.class, args);
        log.info("-------------------------------------- 应用程序启动完成 --------------------------------------");
    }


}
