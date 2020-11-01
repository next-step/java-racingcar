package step03;

import step03.strategy.MoveStrategy;

public class Car {
    private String position = "-";

    private Car() {}

    public static Car of() {
        return new Car();
    }

    public void move (MoveStrategy moveStrategy) {
        if (moveStrategy.isGoing()) {
            position = position.concat("-");
        }
    }

    public String position() {
        return this.position;
    }

}
