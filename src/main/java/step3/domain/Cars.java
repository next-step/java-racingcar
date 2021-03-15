package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCar(String[] names, int initPosition) {
        Arrays.stream(names)
            .forEach(name -> cars.add(new Car(name, initPosition)));
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getWinners() {
        Car maxPositionCar = getMaxPositionCar();

        return cars.stream()
            .filter(car -> car.isMaxPosition(maxPositionCar))
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private Car getMaxPositionCar() {
        return cars.stream()
            .max(Car::compareTo)
            .get();
    }
}
