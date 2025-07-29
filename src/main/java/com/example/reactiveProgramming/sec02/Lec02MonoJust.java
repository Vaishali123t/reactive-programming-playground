package com.example.reactiveProgramming.sec02;

import com.example.reactiveProgramming.sec01.Subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    private static final Logger logger = LoggerFactory.getLogger(Lec02MonoJust.class);

    public static void main(String[] args) {

        Publisher<String> publisher = Mono.just("Hello");
        logger.info("First "+publisher.toString()); // won't emit the value

        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(10); // it prints
    }


}
