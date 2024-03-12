package race.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(int numberOfCar) {
        cars = generateCar(numberOfCar);
    }

    public static Cars createInstance(int numberOfCar) {
        return new Cars(numberOfCar);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> generateCar(int numberOfCar) {
        List<Car> cars = new ArrayList<>();

        while(numberOfCar > 0) {
            cars.add(Car.createInstance());
            numberOfCar--;
        }

        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int getSize() {
        return cars.size();
    }
}
