package step3;

import java.util.ArrayList;
import java.util.List;

import static step3.RandomNumber.generateRandomNumber;

public class CarStorage {
    private final List<Car> cars;

    public CarStorage(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void printLocation(int tryCount) {
        printInitCarLocations();
        printCarLocationsExceptInitCar(tryCount);
    }

    private void printCarLocationsExceptInitCar(int tryCount) {
        for (int carSequence = 1; carSequence < tryCount; carSequence++) {
            printCarLocations();
        }
    }

    private void printCarLocations() {
        for (Car car : cars) {
            System.out.println(getCarLocation(car));
        }
        System.out.println();
    }

    private void printInitCarLocations() {
        for (Car car : cars) {
            System.out.println(car.getLocation());
        }
        System.out.println();
    }

    private StringBuffer getCarLocation(Car car) {
        return car.getAdvancedOrDefaultLocation(generateRandomNumber());
    }
}
