package com.cacoota.study.controller;

import com.alibaba.fastjson.JSON;
import com.cacoota.study.model.search.SearchDemo;
import com.cacoota.study.service.search.SearchDemoService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Autowired
    private SearchDemoService service;

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Welcome to search reactive world ~");
    }

    @GetMapping("/template")
    public void template() {
        SearchDemo demo = new SearchDemo(1L, "川川", "http://127.0.0.1:8888/123.jpg");
        String result = service.insert(demo);
        log.info("插入成功，{}", result);
    }

    @GetMapping("/repository")
    public void repository() {
        SearchDemo demo = new SearchDemo(2L, "娜娜", "http://127.0.0.1:8888/234.jpg");
        SearchDemo result = service.save(demo);
        log.info("插入成功，{}", result);
        Iterable<SearchDemo> demos = service.find("name");
        demos.forEach(item -> log.info("查询成功，{}", item));
    }

    @GetMapping("/matchs")
    public String matchs() {
        MatchQueryBuilder builder = QueryBuilders.matchQuery("name", "川川");
        Iterable<SearchDemo> demos = service.matchSearch(builder);
        demos.forEach(item -> log.info("查询成功，{}", item));
        return JSON.toJSONString(demos);
    }

    @GetMapping("/natives")
    public String natives() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.matchQuery("name", "川川"));
        Page<SearchDemo> demos = service.nativeSearch(builder);
        demos.forEach(item -> log.info("查询成功，{}", item));
        return JSON.toJSONString(demos);
    }


}
