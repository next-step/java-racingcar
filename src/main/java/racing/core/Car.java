package racing.core;

import java.util.Objects;

public class Car {

    private CarDetails carDetails;

    public Car(CarDetails carDetails){
        this.carDetails = carDetails;
    }

    public Car(String carName){
        this.carDetails = new CarDetails(1, carName);
    }

    public CarDetails getCarDetails() {
        return carDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carDetails, car.carDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carDetails);
    }

    public void stepAhead() {
        carDetails.stepAhead();
    }

    public boolean isSameDistance(int distance){
        return carDetails.getDistance() == distance;
    }
}
