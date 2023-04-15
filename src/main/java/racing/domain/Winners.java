package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<RacingCar> winners;

    public Winners(List<RacingCar> cars) {
        this.winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);
        findWinners(cars, maxPosition);
    }

    private static int getMaxPosition(List<RacingCar> cars) {
        return Collections.max(cars).getPosition();
    }

    private void findWinners(List<RacingCar> cars, int maxPosition) {
        for (RacingCar car : cars) {
            addWinner(maxPosition, car);
        }
    }

    private void addWinner(int maxPosition, RacingCar winner) {
        if (winner.getPosition() == maxPosition) {
            winners.add(winner);
        }
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnerNames.add(winner.getName());
        }
        return winnerNames;
    }

    public int getWinnerCount() {
        return winners.size();
    }

    public int getWinnerPosition() {
        return getMaxPosition(winners);
    }
}
