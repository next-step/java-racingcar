package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {
    private final int maxPosition;

    public WinnerFinder(int maxPosition) {
        this.maxPosition = maxPosition;
    }

    public List<String> findWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(car, winners);
        }
        return winners;
    }

    private void addWinner(Car car, List<String> winners) {
        if (car.isWinner(maxPosition)) {
            winners.add(car.getName());
        }
    }

}
