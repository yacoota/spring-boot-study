package com.cacoota.study.controller;

import com.cacoota.study.service.redis.RedisDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    @Autowired
    private RedisDemoService service;

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Welcome to redis reactive world ~");
    }

    @GetMapping("1")
    public void redis1() {
        Mono mono1 = service.save("a", "测试REDIS数据'A'");
        mono1.subscribe(consumer -> log.info("{}", consumer.toString()));
        Mono mono2 = service.save("b", "测试REDIS数据'B'");
        mono2.subscribe(consumer -> log.info("{}", consumer.toString()));
        Mono mono3 = service.save("c", "测试REDIS数据'C'");
        mono3.subscribe(consumer -> log.info("{}", consumer.toString()));
    }

    @GetMapping("/2")
    public Mono redis2() {
        return service.find("a");
    }

    @GetMapping("/3")
    public Flux redis3() {
        Flux flux = service.show(new String[]{"a", "b", "c"});
        flux.subscribe(consumer -> log.info("{}", consumer.toString()));
        return flux;
    }
}
