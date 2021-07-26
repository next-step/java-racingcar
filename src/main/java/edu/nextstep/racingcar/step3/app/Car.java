package edu.nextstep.racingcar.step3.app;

public class Car {

    private final MoveStrategy moveStrategy;
    private int distance = 1;

    public Car(ParamsValidator paramsValidator, MoveStrategy moveStrategy) {
        paramsValidator.validate();

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

    public interface ParamsValidator {
        void validate();
    }

    public interface MoveStrategy {
        Boolean isMove();
    }
}
