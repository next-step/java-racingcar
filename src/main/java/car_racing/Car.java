package car_racing;

import car_racing.move_strategy.MoveStrategy;

public class Car {

    private static final Integer START_POSITION = 1;

    private Integer position;
    private MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
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
