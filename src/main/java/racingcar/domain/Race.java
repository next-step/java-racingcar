package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class Race {

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void raceOneStage() {
        for (Car car : cars) {
            car.raceOneTime(RandomNumberGenerator.getRandomNumber());
        }
        OutputView.printCurrentPosition(cars);
        System.out.println();
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
