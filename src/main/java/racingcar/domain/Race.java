package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class Race {

    private static final int MAX_NUMBER = 10;
    private static final int MIN_NUMBER_FOR_START = 4;
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void repeatGame(Times times) {
        while (times.isOngoing()) {
            raceOneStage(cars);
            times.decrease();
        }
    }

    private void raceOneStage(List<Car> cars) {
        for (Car car : cars) {
            raceOneTime(car, getRandomNumber());
        }
        OutputView.printCurrentPosition(cars);
        System.out.println();
    }

    private int getRandomNumber() {
        return (int) Math.floor(Math.random() * MAX_NUMBER);
    }

    public void raceOneTime(Car car, int randomNumber) {
        if (randomNumber >= MIN_NUMBER_FOR_START) {
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
}
