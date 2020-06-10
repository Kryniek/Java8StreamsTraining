package com.kryniek.training.Java8Streams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Ex1AnonymousClassVsLambda {
    @Test
    void java7() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from Java 7 new Thread!");
            }
        }).start();
    }

    @Test
    void java8() {
        new Thread(() -> {
            System.out.println("Hello from Java 8 new Thread!");
        }).start();
    }
}
