package step4.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars(String  carNames) {
        registerCar(carNames);
    }

    private void registerCar(String carNames) {
        cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(toList());
    }

    public String getWinnerNames() {
        return getWinners().stream().map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private List<Car> getWinners() {
        Optional<Car> winner = cars.stream().max(Comparator.comparingInt(Car::getPosition));
        return cars.stream()
                .filter(car -> car.isSamePosition(winner.get().getPosition()))
                .collect(toList());
    }
}
