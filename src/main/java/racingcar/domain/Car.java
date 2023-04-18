package racingcar.domain;

import racingcar.strategy.NumberGeneratorStrategy;

public class Car {
    private int point = 0;

    private NumberGeneratorStrategy numberGeneratorStrategy;
    public static final int MOVABLE_NUMBER_CONDITION = 4;

    public void move() {
        final int number = numberGeneratorStrategy.generateNumber();
        if (number >= MOVABLE_NUMBER_CONDITION) {
            this.point += 1;
        }
    }

    public int findCarPoint() {
        return point;
    }

    public void initMoveStrategy(NumberGeneratorStrategy numberGeneratorStrategy) {
        this.numberGeneratorStrategy = numberGeneratorStrategy;
    }
}
