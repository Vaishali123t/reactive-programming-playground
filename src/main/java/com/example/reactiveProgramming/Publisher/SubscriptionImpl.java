package com.example.reactiveProgramming.Publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionImpl.class);
    private final Faker faker;
    private static final int MAX_ITEMS=10;
    private Subscriber subscriber;
    private boolean isCancelled;
    private int count = 0;

    public SubscriptionImpl(Subscriber subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if (isCancelled) {
            return;
        }
        logger.info("Subscriber has requested {} items",requested);

        if (requested > MAX_ITEMS) { // error simulation

            this.subscriber.onError(new RuntimeException("Validation failed"));
            return;
        }

        for (int i=0; i<requested && count<MAX_ITEMS; i++) {
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if (count==MAX_ITEMS) {
            logger.info("No more data to produce");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }

    }

    @Override
    public void cancel() {
        logger.info("Subscriber has cancelled the subscription");
        this.isCancelled = true;
    }
}
