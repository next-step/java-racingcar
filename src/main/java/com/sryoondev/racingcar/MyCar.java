package com.sryoondev.racingcar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyCar {
    private static final int MOVABLE_THRESHOLD = 4;

    private int moveCount = 0;

    public void move() {
        this.moveCount++;
    }

    public String printRoute() {
        return IntStream.range(0, moveCount)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    public void stop() {
        // do nothing
    }

    public void race(int randomNumber) {
        if (randomNumber >= MOVABLE_THRESHOLD) {
            move();
        }
    }
}
