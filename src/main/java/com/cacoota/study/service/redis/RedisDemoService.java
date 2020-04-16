package com.cacoota.study.service.redis;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RedisDemoService {

    Mono save(String key, String value);

    Mono find(String key);

    Flux show(String[] data);

    Mono publishTo(String key, Object value);

    Flux subscribeOn(String... channels);
    
}
