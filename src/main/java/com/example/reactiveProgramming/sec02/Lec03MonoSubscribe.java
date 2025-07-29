package com.example.reactiveProgramming.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    private static final Logger logger = LoggerFactory.getLogger(Lec03MonoSubscribe.class);

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("76");

        logger.info(mono.subscribe().toString());
    }

}
