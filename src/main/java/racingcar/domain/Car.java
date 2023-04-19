package racingcar.domain;

import java.util.Objects;

public class Car {

    public static final int MOVE_STANDARD = 4;

    private final CarName carName;
    private MoveCount moveCount;

    public Car(String name, int count) {
        this.carName = new CarName(name);
        this.moveCount = new MoveCount(count);
    }

    public CarName carName() {
        return carName;
    }

    public MoveCount moveCount() {
        return moveCount;
    }

    public void makeMoveCount(int number) {
        if(isCarMovable(number)) {
            moveCount.increase();
        }
    }

    private boolean isCarMovable(int number) {
        return number >= MOVE_STANDARD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(moveCount, car.moveCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, moveCount);
    }
}
