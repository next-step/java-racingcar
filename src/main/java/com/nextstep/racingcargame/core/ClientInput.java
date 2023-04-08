package com.nextstep.racingcargame.core;

import static java.util.Arrays.stream;

import java.util.ArrayList;
import java.util.List;

public class ClientInput {

    public static final String HAS_NEGATIVE_MSG = "음수값으론 경기를 진행할 수 없습니다.";
    private final int numberOfCars;
    private final int numberOfTries;

    public ClientInput(int numberOfCars, int numberOfTries) {
        if (hasNegative(numberOfCars, numberOfTries)) {
            throw new IllegalArgumentException(HAS_NEGATIVE_MSG);
        }
        this.numberOfCars = numberOfCars;
        this.numberOfTries = numberOfTries;
    }

    private boolean hasNegative(int... clientInputs) {
        return stream(clientInputs)
                .anyMatch(clientInput -> clientInput < 1);
    }

    public Cars createCarsByUserCarNumberInput() {
        return new Cars(this.numberOfCars);
    }

    public int getNumberOfTries() {
        return this.numberOfTries;
    }

    @Override
    public String toString() {
        return "ClientInput{" +
                "numberOfCars=" + numberOfCars +
                ", numberOfTries=" + numberOfTries +
                '}';
    }
}
