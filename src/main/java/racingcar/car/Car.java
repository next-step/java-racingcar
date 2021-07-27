package racingcar.car;

import racingcar.strategy.MoveStrategy;

public class Car {

    private CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }
}
