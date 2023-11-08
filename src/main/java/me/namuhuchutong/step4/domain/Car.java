package me.namuhuchutong.step4.domain;

import me.namuhuchutong.step4.domain.rule.RacingRule;

public class Car {

    private static final int FORWARD_VALUE = 1;

    private int position;
    private final String name;

    public static Car from(Car car) {
        return new Car(car.position, car.name);
    }

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void move(RacingRule racingRule) {
        if (racingRule.isSatisfiedRule()) {
            this.position += FORWARD_VALUE;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
