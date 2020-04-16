package com.cacoota.study.service.mongo;

import com.cacoota.study.model.mongo.MongoDemo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface MongoDemoService {

    Mono<MongoDemo> insert(MongoDemo demo);

    Mono<MongoDemo> save(MongoDemo demo);

    Flux<MongoDemo> find(String name);

}
