package racing.domain;

import racing.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<Car>();
    }

    public static Cars from(String[] carNames) {
        return generateCarsWithName(carNames);
    }

    public static Cars from(int carCounts) {
        return generateCars(carCounts);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public Cars addCar(Car car) {
        this.cars.add(car);
        return this;
    }

    private static Cars generateCars(int carCount) {
        Cars cars = new Cars();
        for (int i = 0; i < carCount; i++) {
            cars.addCar(new Car());
        }
        return cars;
    }

    private static Cars generateCarsWithName(String[] carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }
        return cars;
    }

    public void move() {
        for (Car car : getCars()) {
            car.move(RandomUtils.generateRandomNumber());
        }
    }
}