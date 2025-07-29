package com.example.reactiveProgramming.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec06MonoFromCallable {

    private static final Logger logger = LoggerFactory.getLogger(Lec06MonoFromCallable.class);

    public static void main(String[] args) {

        var list2 = List.of(2,3,4);
        // sum(list) in Mono.fromSupplier isn't executed since it's lazy
        Mono<Integer> ans2 = Mono.fromCallable(()->sum(list2)); // Mono.fromSupplier(()->sum(list2)) will show error here
        // before subscription
        logger.info("Before subscription");
        ans2.subscribe(System.out::println);
    }

    // throwing a checked exception -> still no need for try catch in fromCallable
    private static int sum(List<Integer> nums) throws Exception{
        logger.info("Finding the sum of {}",nums);
        return nums.stream().mapToInt(num->num).sum();
    }

}
