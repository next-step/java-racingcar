package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int INIT_VALUE = 0;
    private static final int MOVABLE_STANDARD = 4;

    private final CarName carName;
    private MoveCount moveCount;

    public Car(CarName carName, MoveCount moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public Car(String name, int count) {
        this(new CarName(name), new MoveCount(count));
    }

    public Car(String name) {
        this(new CarName(name), new MoveCount(INIT_VALUE));
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
