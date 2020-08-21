package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static int WINNER_POSITION;
    private final List<Car> cars;

    Cars(List<Car> carList) {
        this.cars = carList;
    }

    public static Cars create(List<Car> carList) {
        return new Cars(carList);
    }

    public static List<Car> startRound(Cars cars) {
        cars.cars.stream().forEach(car -> car.carAction(new RandomNumberMoveStrategy()));
        return cars.cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public static List<Car> getWinners(Cars cars) {
        List<Car> winners = cars.sortCars(cars)
                                .stream()
                                .filter(car -> car.position == WINNER_POSITION)
                                .collect(Collectors.toList());
        return winners;
    }

    private List<Car> sortCars(Cars cars) {
        List<Car> comparedCars = new ArrayList<>(cars.cars);
        Collections.sort(comparedCars);
        WINNER_POSITION = comparedCars.get(0).position;
        return comparedCars;
    }

    public static List<String> getWinnersName(Cars cars) {
        List<String> winnersName = new ArrayList<>();
        getWinners(cars).stream().forEach(car -> winnersName.add(car.name));
        return winnersName;
    }
}
