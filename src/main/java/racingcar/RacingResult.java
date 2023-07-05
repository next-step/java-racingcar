package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private final List<Cars> racingHistory = new ArrayList<>();
    private List<String> winnerNames = new ArrayList<>();

    public void addResult(Cars cars) {
        racingHistory.add(cars);
    }

    public void computeWinner(Cars cars) {
        winnerNames = cars.findWinnerNames();
    }

    public List<Cars> getRacingHistory() {
        return racingHistory;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
