package racingGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> winners;
    private List<String> winnerNames = new ArrayList<>();

    public Winner(List<Car> winners) {
        this.winners = winners;
    }

    public List<String> findWinnerNames() {
        for (Car winner : winners) {
            this.addWinnerNames(winner, this.maxPosition());
        }
        return winnerNames;
    }

    private void addWinnerNames(Car nowCar, int maxPosition) {
        if (nowCar.getPosition() == maxPosition) {
            winnerNames.add(nowCar.getName());
        }
    }

    private int maxPosition() {
        int maxPosition = 0;
        for (Car car : winners) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
