package step2;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int STARTING_POINT = 0;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars newCars(int numberOfCar) {
        List<Car> newCars = new ArrayList<>();
        for (int carNo = 0; carNo < numberOfCar; carNo++) {
            newCars.add(new Car(carNo, STARTING_POINT));
        }

        return new Cars(newCars);
    }

    public Cars startTurn() {
        List<Car> newCars = new ArrayList<>();
        for (Car car : this.getCars()) {
            Car movedCar = car.move();
            newCars.add(movedCar);
        }

        return new Cars(newCars);
    }

    public List<Car> getCars() {
        return cars;
    }

}
