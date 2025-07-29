package com.example.reactiveProgramming.sec02;

import com.example.reactiveProgramming.common.DefaultSubscriberImpl;
import com.example.reactiveProgramming.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {

    private static final Logger logger = LoggerFactory.getLogger(Lec04MonoEmptyError.class);

    public static void main(String[] args) {
            getUserName(3)
                    .subscribe(Util.subscriber());
    }

    private static Mono<String> getUserName(int userId) {
        return switch (userId) {
            case 1 -> Mono.just("sam");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid Input"));
        };
    }

}
