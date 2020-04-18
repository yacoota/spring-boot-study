package com.cacoota.study.controller;

import com.alibaba.fastjson.JSON;
import com.cacoota.study.model.mongo.MongoDemo;
import com.cacoota.study.service.mongo.MongoDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mongo")
@Slf4j
public class MongoController {

    @Autowired
    private MongoDemoService service;

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Welcome to mongo reactive world ~");
    }

    @GetMapping("/template")
    public void template() {
        MongoDemo demo = new MongoDemo(1L, "川川", "男", "WYC");
        Mono<MongoDemo> mono = service.insert(demo);
        mono.subscribe(u -> log.info("保存成功，{}", u));
    }

    @GetMapping("/repository")
    public String repository() {
        MongoDemo demo = new MongoDemo(2L, "娜娜", "女", "DNA");
        Mono<MongoDemo> mono = service.save(demo);
        mono.subscribe(u -> log.info("保存成功，{}", u));

        Flux<MongoDemo> flux = service.find("DNA");
        flux.subscribe(u -> log.info("查询成功，{}", u));
        return JSON.toJSONString(flux);
    }
}
