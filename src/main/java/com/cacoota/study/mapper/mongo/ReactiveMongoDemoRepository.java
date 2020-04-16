package com.cacoota.study.mapper.mongo;

import com.cacoota.study.model.mongo.MongoDemo;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface ReactiveMongoDemoRepository extends ReactiveSortingRepository<MongoDemo, Long> {

    Flux<MongoDemo> findByUsername(String username);

}
