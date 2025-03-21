package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarWinnerCalculator {

    private final List<CarPositions> history;

    public CarWinnerCalculator(List<CarPositions> history) {
        this.history = history;
    }

    public List<String> determineWinners() {
        List<CarPosition> carPositions = getLastCarPositions().getPositions();

        int maxPosition = findMaxPosition(carPositions);
        return findWinners(carPositions, maxPosition);
    }

    private CarPositions getLastCarPositions() {
        return history.get(history.size() - 1);
    }

    private int findMaxPosition(List<CarPosition> carPositions) {
        int maxPosition = 0;

        for (CarPosition position : carPositions) {
            maxPosition = position.max(maxPosition);
        }

        return maxPosition;
    }

    private List<String> findWinners(List<CarPosition> carPositions, int maxPosition) {
        List<String> winners = new ArrayList<>();

        for (CarPosition position : carPositions) {
            if (position.getPosition() == maxPosition) {
                winners.add(position.getName());
            }
        }

        return winners;
    }
}
