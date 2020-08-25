package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static int WINNER_POSITION;
    private List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        Arrays.stream(carNames).forEach(carName -> cars.add(Car.create(carName)));
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    public void startRound(MoveStrategy moveStrategy) {
        stream().forEach(car -> car.carAction(moveStrategy));
    }

    public static List<Car> getWinnersList(Cars cars) {
        return cars.getWinnersCars()
                .stream()
                .filter(car -> car.position == WINNER_POSITION)
                .collect(Collectors.toList());
    }

    private List<Car> getWinnersCars() {
        List<Car> comparedCars = cars.stream()
                .sorted((a, b) -> a.compareTo(b))
                .collect(Collectors.toList());
        WINNER_POSITION = comparedCars.get(0).position;
        return comparedCars;
    }

    public static List<String> getWinnersNames(Cars cars) {
        List<String> winnersName = new ArrayList<>();
        getWinnersList(cars)
                .stream()
                .map(car -> winnersName.add(car.name))
                .collect(Collectors.toList());
        return winnersName;
    }
}
