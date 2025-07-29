package com.example.reactiveProgramming.sec02;

import com.example.reactiveProgramming.common.DefaultSubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec05MonoFromSupplier {

    private static final Logger logger = LoggerFactory.getLogger(Lec05MonoFromSupplier.class);

    public static void main(String[] args) {

        var list1 = List.of(1,2,3);
        // sum(list) executes as Mono.just() is eager (but sum is not returned since it's not subscribed)
        Mono<Integer> ans1= Mono.just(sum(list1));

        var list2 = List.of(2,3,4);
        // sum(list) in Mono.fromSupplier isn't executed since it's lazy
        Mono<Integer> ans2 = Mono.fromSupplier(()->sum(list2));
        // before subscription
        logger.info("Before subscription");
        ans2.subscribe(System.out::println);
    }

    private static int sum(List<Integer> nums) { // imagine this is a compute intensive operation
        logger.info("Finding the sum of {}",nums);
        return nums.stream().mapToInt(num->num).sum();
    }
}
