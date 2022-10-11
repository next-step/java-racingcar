package step3.car_racing.model;

import step3.car_racing.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    private static final Integer MIN_DISTANCE = 1;

    public Cars initCars(List<String> carNameList) {
        for (String name : carNameList) {
            this.carList.add(new Car().initCar(name));
        }
        return this;
    }

    public Cars resultCars(List<Car> carList) {
        for (Car car : carList) {
            this.carList.add(new Car().resultCar(car.getName(), car.getDistance()));
        }
        return this;
    }

    public List<Car> move() {
        for (Car car : this.carList) {
            car.move(new RandomUtil());
        }
        return this.carList;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<String> findWinner() {
        int max = this.carList
                .stream()
                .mapToInt(Car::getDistanceLength)
                .max()
                .orElse(MIN_DISTANCE);

        return this.carList
                .stream()
                .filter(car -> car.getDistanceLength() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
