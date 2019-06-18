package racingcar.model;

import racingcar.util.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(Names names) {
        List<Car> cars = names.stream()
                .map(name -> Car.create(name))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public Cars move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.getNumber());
        }
        return this;
    }

    public List<Car> winningCars() {
        return cars.stream()
                .filter(car -> isMaxPosition(car))
                .collect(Collectors.toList());
    }

    public boolean isMaxPosition(Car car) {
        return Position.max() == car.getPosition();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" + "cars=" + cars + '}';
    }
}
