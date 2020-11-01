package step03;

import step03.strategy.MoveStrategy;

public class Car {
    private String position;
    private final String carKind;

    private Car(String carKind) {
        this.position = carKind;
        this.carKind = carKind;
    }

    public static Car of(String carKind) {
        return new Car(carKind);
    }

    public void move (MoveStrategy moveStrategy) {
        if (moveStrategy.isGoing()) {
            position = position.concat(carKind);
        }
    }

    public String position() {
        return this.position;
    }

}
