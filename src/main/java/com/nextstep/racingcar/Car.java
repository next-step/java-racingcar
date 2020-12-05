package com.nextstep.racingcar;

import java.util.function.Supplier;

public class Car {
    private static final int THRESHOLD = 3;

    private CarName name;
    private int position = 0;
    private Supplier<Integer> numberGenerator;

    public Car(CarName name, Supplier<Integer> numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return name.getName();
    }

    public void tryMove() {
        int number = numberGenerator.get();
        if (isMove(number)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isFinished(int limit) {
        return limit <= position;
    }

    public boolean isNotFinished(int limit) {
        return position < limit;
    }

    private boolean isMove(int number) {
        return THRESHOLD < number;
    }
}
