package racingcar;

public class Car {
    private int position;
    private MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        position = 0;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        position += moveStrategy.getMovement();
    }

    public int getPosition() {
        return position;
    }
}
