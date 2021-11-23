package racing.model;

import java.util.*;
import java.util.stream.Collectors;

/*
 *
 * Cars
 *
 * @version 1.0.0
 *
 * 2021-11-23
 *
 * Copyright tnals1422
 */
public class Cars {

    private final List<Car> cars;

    public Cars(String carName) {
        cars = Arrays.stream(carName.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(List<Car> cars) {
        List<Car> carList = new LinkedList<>();
        for (Car car : cars) {
            carList.add(new Car(car));
        }
        this.cars = carList;
    }

    public List<Car> moveCars() {
        cars.forEach(car -> car.move(ConditionGenerator.generate()));
        return cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> winners() {
        List<Car> result = cars.stream()
                .filter(car -> car.isWinner(cars))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(result);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
