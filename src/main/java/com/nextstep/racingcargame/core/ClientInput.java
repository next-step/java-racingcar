package com.nextstep.racingcargame.core;

import static java.util.Arrays.stream;

public class ClientInput {

    public static final String HAS_NEGATIVE_MSG = "음수는 입력할 수 없습니다.";
    private final int numberOfCars;
    private final int numberOfTries;

    public ClientInput(int numberOfCars, int numberOfTries) {
        if(hasNegative(numberOfCars,numberOfTries)) {
            throw new IllegalArgumentException(HAS_NEGATIVE_MSG);
        }
        this.numberOfCars = numberOfCars;
        this.numberOfTries = numberOfTries;
    }

    private boolean hasNegative(int... clientInputs) {
        return stream(clientInputs)
                .anyMatch(clientInput -> clientInput < 1);
    }
}
