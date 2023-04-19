package racingcar.domain;

import racingcar.strategy.NumberGeneratorStrategy;

public class Car {
    private int point = 0;

    public void move(NumberGeneratorStrategy numberGeneratorStrategy) {
        final int number = numberGeneratorStrategy.generateNumber();
        if (numberGeneratorStrategy.isMovable(number)) {
            this.point += 1;
        }
    }

    public int findCarPoint() {
        return point;
    }
}
