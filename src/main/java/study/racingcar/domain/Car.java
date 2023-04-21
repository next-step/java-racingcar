package study.racingcar.domain;

import study.racingcar.rule.DomainRule;

public class Car {
    private final Position position;
    private final CarName carName;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public Car(String carName, int position) {
        this.carName = new CarName(carName);
        this.position = new Position(position);
    }

    public void move() {
        position.increase();
    }

    public static boolean isMovable(DomainRule rule) {
        int value = rule.generate();
        return value >= DomainRule.MOVABLE_LOWER_BOUND;
    }

    public String getCarName() {
        return carName.toString();
    }

    public int getPosition() {
        return Integer.parseInt(position.toString());
    }
}