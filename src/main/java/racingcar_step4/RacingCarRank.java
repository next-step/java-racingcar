package racingcar_step4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarRank {

    private List<Car> winners;

    public List<Car> rankCars(List<Car> cars) {
        reverseSortCars(cars);

        winners = new ArrayList<>();
        Car winner = cars.get(0);
        winners.add(winner);

        for (int i=1; i < cars.size(); i++) {
            checkSameScore(winner, cars.get(i));
        }
        return winners;
    }

    private void reverseSortCars(List<Car> cars) {
        cars.sort(Collections.reverseOrder());
    }

    private void checkSameScore(Car winner, Car otherCar) {
        if (winner.compareTo(otherCar) == 0) {
            winners.add(otherCar);
        }
    }
}
