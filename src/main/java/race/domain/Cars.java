package race.domain;

import race.utils.PlayStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public List<Car> goForward(PlayStrategy rule) {
        List<Car> carList = new ArrayList<>();
        for (Car car : this.cars) {
            goForwardWith(rule, car);
            carList.add(new Car(car.getPosition(), car.getName()));
        }
        return Collections.unmodifiableList(carList);
    }

    private void goForwardWith(PlayStrategy rule, Car car) {
        if (rule.isValidForGoForward()) {
            car.go();
        }
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
