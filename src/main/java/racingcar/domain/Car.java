package racingcar.domain;

public class Car {
    private final MoveStrategy moveStrategy;
    private int position = 0;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int getPosition() {
        return position;
    }
}
