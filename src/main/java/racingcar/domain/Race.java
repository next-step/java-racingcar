package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final int MIN_NUMBER_FOR_START = 4;
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void raceOneTime(Car car, int condition) {
        if (condition >= MIN_NUMBER_FOR_START) {
            car.go();
        }
    }

    public List<String> getWinnerNames() {
        int maxPosition = getMaxScore();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSamePosition(maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxScore() {
        int maximum = 0;
        for (Car car : cars) {
            maximum = car.comparePosition(maximum);
        }
        return maximum;
    }

    public List<Car> getCars() {
        return cars;
    }
}
