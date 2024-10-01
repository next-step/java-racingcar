package step3.model;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int MOVE_MIN_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 10;
    private static final Random RANDOM = new Random();

    private int moveCount;
    private final CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return carName.getCarName();
    }

    public void moveOrStop() {
        if (isMove()) {
            moveCount++;
        }
    }

    private boolean isMove() {
        return RANDOM.nextInt(RANDOM_MAX_NUMBER) >= MOVE_MIN_NUMBER;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return carName != null ? carName.hashCode() : 0;
    }
}
