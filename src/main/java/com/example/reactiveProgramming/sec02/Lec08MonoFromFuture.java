package com.example.reactiveProgramming.sec02;

import com.example.reactiveProgramming.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class Lec08MonoFromFuture {

    private static final Logger logger = LoggerFactory.getLogger(Lec08MonoFromFuture.class);

    public static void main(String[] args) {

        Mono<String> mono1 = Mono.fromFuture(getName()); // gets executed even when not subscribed
        Mono<String> mono2 = Mono.fromFuture(() ->getBloodGroup()); // doesn't get executed until subscribed

        logger.info("Before subscription");
        mono1.subscribe(System.out::println);
        mono2.subscribe(System.out::println);

        /* We are putting this just to see response as CompletableFuture works on some other thread and if we won't sleep
        then the main thread will complete, and we won't see the response
         */
        Util.sleep(Duration.ofSeconds(2));
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() ->  {
            logger.info("Generating name");
            return Util.faker().name().fullName();
        });
    }

    private static CompletableFuture<String> getBloodGroup() {
        return CompletableFuture.supplyAsync(() ->  {
            logger.info("Generating Blood group");
            return Util.faker().name().bloodGroup();
        });
    }


}
