package step3.domain;

import java.util.Objects;

public abstract class Car {

    private int carId;
    protected String mileAge;

    public Car(int carId) {
        this.carId = carId;
        this.mileAge = "";
    }

    public int getCarId() {
        return carId;
    }

    public String getMileAge() {
        return mileAge;
    }

    public boolean accelerate() {
        return true;
    }

    public boolean brake() {
        return false;
    }

    public abstract boolean move(int racingCondition, int movementPolicy);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId &&
                Objects.equals(mileAge, car.mileAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, mileAge);
    }
}
