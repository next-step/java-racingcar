package study.racingcar.domain;

import study.racingcar.strategy.NumberGenerator;

public class Car {
    /**
     * 차량을 담당한다.
     */
    private final Position position;
    private final CarName carName;

    public Car(String carName) {
        this.position = new Position();
        this.carName = new CarName(carName);
    }

    public void move() {
        position.increase();
    }

    public static boolean isMovable(NumberGenerator numberGenerator) {
        int value = numberGenerator.generate();
        return value >= Rule.MOVABLE_LOWER_BOUND;
    }

    @Override
    public String toString() {
        return Rule.CAR_SHAPE.repeat(position.getPosition());
    }

    public String getCarName() {
        return carName.toString();
    }
}