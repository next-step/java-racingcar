package racingcar.domain;

import racingcar.strategy.NumberGeneratorStrategy;

public class Car {
    private int point = 0;
    private String name;
    
    public Car(String carName) {
        this(0, carName);
    }

    public Car(int point, String name) {
        this.point = point;
        this.name = name;
    }

    public void move(NumberGeneratorStrategy numberGeneratorStrategy) {
        final int number = numberGeneratorStrategy.generateNumber();
        if (numberGeneratorStrategy.isMovable(number)) {
            this.point += 1;
        }
    }

    public int findCarPoint() {
        return point;
    }

    public String findCarName() {
        return name;
    }
}
