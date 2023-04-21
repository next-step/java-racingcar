package step3.model;

import step3.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void checkForwardConditionAndGo() {
        for (Car car : cars) {
            car.increaseDistance();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public int getCarSize() {
        return cars.size();
    }

    public static Cars generateCars(int carCount) {
        List<Car> tempCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
            Car car = new Car(0, randomNumberGenerator);
            tempCars.add(car);
        }

        return new Cars(tempCars);
    }

}
