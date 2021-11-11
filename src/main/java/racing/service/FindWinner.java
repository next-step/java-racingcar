package racing.service;

import racing.model.Car;
import racing.model.Cars;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindWinner {
    public static List<Car> findWinner(Cars cars) {
        Optional<Integer> maxInteger = cars.getCarList().stream().map(i -> i.getPosition()).max(Comparator.comparing(x -> x));
        return cars.getCarList().stream().filter(i -> i.getPosition() >= maxInteger.get()).collect(Collectors.toList());
    }
}
