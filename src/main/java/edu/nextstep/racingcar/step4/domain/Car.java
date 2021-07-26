package edu.nextstep.racingcar.step4.domain;

public class Car {

    private final MoveStrategy moveStrategy;
    private int distance = 1;

    private String name;

    public Car(String name,ParamsValidator paramsValidator, MoveStrategy moveStrategy) {
        paramsValidator.validate();

        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.isMove()) {
            this.distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public interface ParamsValidator {
        void validate();
    }

    public interface MoveStrategy {
        Boolean isMove();
    }
}
