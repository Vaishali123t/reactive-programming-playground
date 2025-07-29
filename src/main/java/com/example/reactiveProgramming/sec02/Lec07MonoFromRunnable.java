package com.example.reactiveProgramming.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec07MonoFromRunnable {

    private static final Logger logger = LoggerFactory.getLogger(Lec07MonoFromRunnable.class);

    public static void main(String[] args) {

        Mono<Void> mono = Mono.fromRunnable(() -> {
            System.out.println("Doing something important...");
        });

        System.out.println("Before subscribe");
        mono.subscribe(
                null,
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Completed")
        );
    }


}
