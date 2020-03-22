package racingcar.domain;

public class Car {
    public static final int START_POSITION = 0;

    private int position;

    public Car() {
        this.position = START_POSITION;
    }

    Car(Integer position) {
        this.position = position;
    }

    Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            position++;
        }
        return new Car(position);
    }

    public int getPosition() {
        return position;
    }
}
