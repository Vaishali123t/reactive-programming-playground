package com.example.reactiveProgramming.sec02;

import com.example.reactiveProgramming.common.Util;
import reactor.core.publisher.Mono;

public class GVU {

    public static void main(String[] args) {
        GVU.get().subscribe(val -> System.out.println("Received: " + val));
    }


    static Mono<Integer> get(){
        return Mono.fromRunnable(() -> {
            int a = 1 * 2;
        });
    }

}
