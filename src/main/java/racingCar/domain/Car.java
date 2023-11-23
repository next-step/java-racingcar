package racingCar.domain;

public class Car {
    private static final int RUNNABLE_LIMIT_NUMBER = 4;
    private static final String DEFAULT_CAR_NAME = "car";

    private CarName carName;
    private Distance distance;

    public Car(int distance) {
        this.carName = new CarName(DEFAULT_CAR_NAME);
        this.distance = new Distance(distance);
    }

    public Car(CarName carName){
        this.carName = carName;
        this.distance = new Distance();
    }

    public Distance moveForward(int randomNumber) {
        if (isRunnable(randomNumber)) {
             distance.moveForward();
        }
        return distance;
    }

    public Car fasterCar(Car car) {
        if (this.distance.max(car.distance).equals(car.distance)) {
            return car;
        }
        return this;
    }

    private boolean isRunnable(int randomNumber) {
        return randomNumber >= RUNNABLE_LIMIT_NUMBER;
    }

    public Distance distance() {
        return this.distance;
    }

    public CarName carName() {
        return this.carName;
    }
}
