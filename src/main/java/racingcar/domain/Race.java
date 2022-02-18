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

    public void repeatGame(int times) {
        for (int j = 0; j < times; j++) {
            for (Car car : cars) {
                raceOneTime(car, (int) Math.floor(Math.random() * MAX_NUMBER));
            }
            OutputView.printCurrentPosition(cars);
            System.out.println();
        }
    }

    public void raceOneTime(Car car, int randomNumber) {
        if (randomNumber >= MIN_NUMBER_FOR_START) {
            car.go();
        }
    }

    public List<String> WinnerNames() {
        int maxPosition = getMaxScore();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSamePosition(maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getMaxScore() {
        int maximum = 0;
        for (Car car : cars) {
            maximum = car.comparePosition(maximum);
        }
        return maximum;
    }
}
