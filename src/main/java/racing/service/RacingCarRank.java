package racing.service;

import racing.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarRank {
    public static void sortCars(List<Car> cars) {
        cars.sort(Collections.reverseOrder());
    }

    public static List<Car> rankCars(List<Car> cars) {
        sortCars(cars);

        List<Car> winners = new ArrayList<>();
        Car winner = cars.get(0);
        winners.add(winner);

        for (int i = 1; i < cars.size(); i++) {
            checkSameScore(winner, cars.get(i), winners);
        }

        return winners;
    }

    public static void checkSameScore(Car winner, Car otherCar, List<Car> winners) {
        if (winner.compareTo(otherCar) == 0) {
            winners.add(otherCar);
        }
    }
}
