package com.example.reactiveProgramming.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DefaultSubscriberImpl<T> implements Subscriber<T> {

    private static final Logger logger = LoggerFactory.getLogger(DefaultSubscriberImpl.class);
    private String name;

    public DefaultSubscriberImpl() {

    }

    public DefaultSubscriberImpl(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        logger.info("Email received " + item);
    }

    @Override
    public void onError(Throwable throwable) {
        logger.info("Errror received ",throwable);
    }

    @Override
    public void onComplete() {
        logger.info("Completed");
    }
}
