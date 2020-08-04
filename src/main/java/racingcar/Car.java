package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int THRESHOLD = 4;
    private int position;

    private Car() {
        this.position = 1;
    }

    private Car(Car car) {
        this.position = car.getPosition();
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int fuel) {
        if (fuel >= THRESHOLD) {
            this.position++;
        }
    }

    public static Car createCar() {
        return new Car();
    }

    public static Car cloneCar(Car car) {
        return new Car(car);
    }

    public static Car[] createAllCars(int numberOfCars) {
        Car[] cars = new Car[numberOfCars];

        for (int i = 0; i < numberOfCars; ++i) {
            cars[i] = createCar();
        }

        return cars;
    }

    /**
     * Deep copy for Cars
     * @param cars
     * @return list of cloned Cars
     */
    public static List<Car> cloneAllCars(Car[] cars) {
        List<Car> cloneCars = new ArrayList<>();

        for (Car car : cars) {
            cloneCars.add(cloneCar(car));
        }

        return cloneCars;
    }
}
