package race.domain;

import race.utils.PlayStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(int numberOfCars, String[] names) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(0, names[i]));
        }
    }

    public List<Car> goForward(PlayStrategy rule) {
        List<Car> carList = new ArrayList<>();
        for (Car car : this.cars) {
            if (rule.isValidForGoForward()) {
                car.go();
            }
            carList.add(new Car(car.getPosition(), car.getName()));
        }
        return Collections.unmodifiableList(carList);
    }

    public String showWinnerNames() {
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition())
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int winnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }



}
