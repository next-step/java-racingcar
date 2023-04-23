package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVABLE_STANDARD = 4;

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

    public void move(int number) {
        if(isCarMovable(number)) {
            moveCount.increase();
        }
    }

    private boolean isCarMovable(int number) {
        return number >= MOVABLE_STANDARD;
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
