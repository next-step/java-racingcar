package com.sryoondev.racingcar;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyRacing {
    private final int racingCount;
    private Random movableNumberGenerator;
    private MyCar[] myCars;

    public MyRacing(int carCount, int racingCount) {
        this.myCars = new MyCar[carCount];
        for (int i = 0; i < carCount; i++) {
            this.myCars[i] = new MyCar();
        }
        this.racingCount = racingCount;
        this.movableNumberGenerator = new Random();
    }

    public int getCarCount() {
        return myCars.length;
    }

    public int getRacingCount() {
        return this.racingCount;
    }

    public String race() {
        return Stream.of(myCars)
                .map(c -> {
                    c.race(movableNumberGenerator.nextInt(10));
                    return c.printRoute();
                }).collect(Collectors.joining("\n"));
    }

    public String start() {
        return IntStream.range(0, racingCount)
                .mapToObj(i -> race())
                .collect(Collectors.joining("\n\n"));
    }
}
