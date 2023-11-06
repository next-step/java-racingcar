package carracing;

import carracing.move_strategy.MoveStrategy;

public class Car {

    private static final int START_POSITION = 1;

    private String name;
    private Integer position;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.position = START_POSITION;
        this.moveStrategy = moveStrategy;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void move() {
        position += moveStrategy.getMovePoint();
    }
}
