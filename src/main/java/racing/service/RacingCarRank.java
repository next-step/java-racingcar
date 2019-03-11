package racing.service;

import racing.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarRank {
    public static void sortCars(List<Car> cars) {

        Collections.sort(cars, Collections.reverseOrder());

    }

    public static List<Car> rankCars(List<Car> cars) {

        List<Car> winners = new ArrayList<>();
        Car winner = cars.get(0);
        winners.add(winner);

        for (int i = 1; i < cars.size(); i++) {
            checkSameScore(winner.getTotalDistance(), cars.get(i), winners);
        }

        return winners;
    }

    public static void checkSameScore(int topDistance, Car otherCar, List<Car> winners) {
        if (topDistance == otherCar.getTotalDistance()) {
            winners.add(otherCar);
        }
    }
}
