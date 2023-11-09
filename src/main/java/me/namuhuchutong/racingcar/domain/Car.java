package me.namuhuchutong.racingcar.domain;

import me.namuhuchutong.racingcar.domain.rule.RacingRule;

public class Car implements Comparable<Car> {

    private static final int FORWARD_VALUE = 1;

    private final int position;
    private final String name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public Car move(RacingRule racingRule) {
        if (racingRule.isSatisfiedRule()) {
            int movedPosition = this.position + FORWARD_VALUE;
            return new Car(movedPosition, this.name);
        }
        return new Car(this.position, this.name);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.getPosition(), car.getPosition());
    }
}
