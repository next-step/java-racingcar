package carracing;

import carracing.move_strategy.MoveStrategy;

public class Car {

    private static final int START_POSITION = 1;

    private CarName name;
    private Integer position;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = CarName.from(name);
        this.position = START_POSITION;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return this.name.getName();
    }

    public Integer getPosition() {
        return this.position;
    }

    public void move() {
        position += moveStrategy.getMovePoint();
    }
}
