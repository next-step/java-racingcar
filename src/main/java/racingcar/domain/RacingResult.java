package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private final List<Cars> racingHistory = new ArrayList<>();
    private List<String> winnerNames = new ArrayList<>();

    public void addResult(Cars cars) {
        racingHistory.add(cars);
    }

    public void addWinnerNames(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<Cars> getRacingHistory() {
        return racingHistory;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
