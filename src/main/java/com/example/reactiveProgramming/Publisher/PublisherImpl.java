package com.example.reactiveProgramming.Publisher;

import com.example.reactiveProgramming.Subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PublisherImpl implements Publisher<String> {

    private static final Logger logger = LoggerFactory.getLogger(PublisherImpl.class);
//    private List<Subscriber> subscribers;

    @Override
    public void subscribe(Subscriber subscriber) {
        var subscription = new SubscriptionImpl(subscriber);
//        subscribers.add(subscriber);
        subscriber.onSubscribe(subscription);

    }
}
