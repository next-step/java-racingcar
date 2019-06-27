package racingcar.dto;

import racingcar.domain.model.RacingCars;
import racingcar.domain.model.Winners;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<RacingCars> snapshot = new ArrayList<>();
    private String winnerNames;

    public void addSnapshot(RacingCars racingCars) {
        snapshot.add(racingCars);
    }

    public void setWinnerNames(String winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<RacingCars> getSnapshot() {
        return new ArrayList<>(snapshot);
    }

    public String getWinnerNames() {
        return winnerNames;
    }
}
