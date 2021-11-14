package racing.service;

import racing.model.Car;
import racing.model.Cars;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindWinner {

    private FindWinner() {

    }
    private static Integer findMaxPosition(Cars cars) {
        return cars.getCarList().stream().map(i -> i.getPosition().getPosition()).max(Comparator.comparing(x -> x)).get();

    }

    public static List<Car> findWinnerList(Cars cars) {
        return cars.getCarList().stream().filter(i -> i.getPosition().getPosition() >= findMaxPosition(cars)).collect(Collectors.toList());
    }
}
