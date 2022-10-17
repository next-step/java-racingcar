package com.nextlevel.kky.racing.core;

import java.security.InvalidParameterException;

public class CarMoveCondition {

    private static final int MAX_VALUE = 9;

    private static final int MIN_VALUE_FOR_MOVE = 4;

    private final IntegerGenerator integerGenerator;

    public CarMoveCondition(IntegerGenerator integerGenerator) {
        this.integerGenerator = integerGenerator;
    }

    public boolean checkMoveCondition() {
        int value = integerGenerator.getValue();
        if (checkRangeValid(value)) {
            throw new InvalidParameterException("not available value");
        }
        return value >= MIN_VALUE_FOR_MOVE;
    }

    public boolean checkRangeValid(int value) {
        return value < 0 || value > MAX_VALUE;
    }
}
