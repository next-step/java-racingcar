package racing.model;

import racing.strategy.MoveStrategy;

public class Car {
    private Integer position;

    private String name;

    public Car(String name) {
        this.position = 0;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void movable(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position++;
        }
    }
}
