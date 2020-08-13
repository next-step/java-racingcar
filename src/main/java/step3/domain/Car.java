package step3.domain;

import java.util.Objects;

public abstract class Car {

    public static int ZERO_NUMBER = 0;
    private String carName;
    protected int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = ZERO_NUMBER;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public abstract int move(int racingCondition, int movementPolicy);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carName == car.carName &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

}
