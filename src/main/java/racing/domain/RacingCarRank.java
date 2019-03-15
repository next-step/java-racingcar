package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarRank {

    private List<Car> winners;

    public void sortCars(List<Car> cars) {
        cars.sort(Collections.reverseOrder());
    }

    public List<Car> rankCars(List<Car> cars) {
        sortCars(cars);

        winners = new ArrayList<>();
        Car winner = cars.get(0);
        winners.add(winner);

        for (int i = 1; i < cars.size(); i++) {
            checkSameScore(winner, cars.get(i));
        }

        return winners;
    }

    public void checkSameScore(Car winner, Car otherCar) {
        if (winner.compareTo(otherCar) == 0) {
            winners.add(otherCar);
        }
    }
}
