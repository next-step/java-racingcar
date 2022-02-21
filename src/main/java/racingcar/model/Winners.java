package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> raceResults;

    public Winners(List<Car> raceResults) {
        this.raceResults = winnerList(raceResults);
    }

    private List<Car> winnerList(List<Car> cars) {
        int maxPosition = maximumDistance(cars);
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isMaxPosition((maxPosition))) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int maximumDistance(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.checkMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> getRaceResults() {
        return raceResults;
    }

}
