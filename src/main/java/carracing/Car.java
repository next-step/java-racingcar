package carracing;

import carracing.move_strategy.MoveStrategy;

public class Car implements Cloneable {

    private static final int START_POSITION = 1;

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

    @Override
    public Car clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return (Car) obj;
    }
}
