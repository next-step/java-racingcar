package step4.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String  carNames) {
        registerCar(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getWinnerNames() {
        return getWinners().stream().map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private void registerCar(String carNames) {
        Stream<String> registerCarNames = Arrays.stream(carNames.split(","));
        registerCarNames.forEach(carName -> cars.add(new Car(carName)));
    }

    private List<Car> getWinners() {
        Optional<Car> winner = cars.stream().max(Comparator.comparingInt(Car::getPosition));
        return cars.stream()
                .filter(car -> car.isSamePosition(winner.get().getPosition()))
                .collect(Collectors.toList());
    }
}
