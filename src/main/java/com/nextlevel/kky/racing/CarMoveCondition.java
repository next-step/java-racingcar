package com.nextlevel.kky.racing;

public class CarMoveCondition {

    public static final int MAX_VALUE = 9;

    private static final int MIN_VALUE_FOR_MOVE = 4;

    private final IntegerGenerator integerGenerator;

    public CarMoveCondition(IntegerGenerator integerGenerator) {
        this.integerGenerator = integerGenerator;
    }

    public boolean checkMoveCondition() {
        int value = integerGenerator.getValue();
        if (value < 0 || value > MAX_VALUE) {
            throw new RuntimeException("not available value");
        }
        return value >= MIN_VALUE_FOR_MOVE;
    }
}
