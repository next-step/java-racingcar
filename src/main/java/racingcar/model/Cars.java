package racingcar.model;

import racingcar.util.NumberGenerator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    public static final String DELIMITER = "\\,";
    private List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String names) {
        CarsValidator.validate(names);
        String[] namesArr = parseArrays(names);
        List<Car> cars = Arrays.stream(namesArr)
                .map(name -> Car.create(name))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static String[] parseArrays(String names) {
        String[] namesArr = names.split(DELIMITER);
        return namesArr;
    }

    Cars moveAll(NumberGenerator numberGenerator) {
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
