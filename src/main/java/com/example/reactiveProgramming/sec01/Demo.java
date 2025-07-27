package com.example.reactiveProgramming.sec01;

import com.example.reactiveProgramming.sec01.Publisher.PublisherImpl;
import com.example.reactiveProgramming.sec01.Subscriber.SubscriberImpl;

import java.time.Duration;

/* To Demo:
1. The publisher does not produce any data unless subscriber requests for it. => method demo1
2. Publisher will only produce <= items requested by subscriber. => method demo2
3. Subscriber can cancel the subscription. Publisher should stop at that moment as subscriber is no longer interested in
 consuming the data. => method demo3
 4. Producer can send error signal  to signify something is wrong. => method demo4
 */


public class Demo {

    public static void main(String[] args) throws InterruptedException {
        demo4();
    }

    private static void demo1() {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    private static void demo2() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(5));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(5));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(5));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(5));
        subscriber.getSubscription().request(3);
    }

    private static void demo3() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(2);
        Thread.sleep(Duration.ofSeconds(3));
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }

    private static void demo4() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(2);
        Thread.sleep(Duration.ofSeconds(3));
        subscriber.getSubscription().request(15);
        Thread.sleep(Duration.ofSeconds(10));
        subscriber.getSubscription().request(2);
    }

}
