package edu.nextstep.racingcar.step3.app;

import java.util.function.Supplier;

public class Car implements Vehicle {

    private final Supplier<Boolean> movement;
    private int distance = 1;

    public Car(ParamsValidator paramsValidator, Supplier<Boolean> movement) {
        paramsValidator.validate();

        this.movement = movement;
    }

    public boolean isMove() {
        return movement.get();
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public interface ParamsValidator {
        void validate();
    }
}
