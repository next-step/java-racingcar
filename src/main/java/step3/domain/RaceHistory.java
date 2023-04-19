package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {
    private final List<RacingCars> raceHistory;

    public RaceHistory() {
        this.raceHistory = new ArrayList<>();
    }

    public void saveRound(RacingCars racingCars) {
        this.raceHistory.add(racingCars);
    }

    public List<RacingCars> getRaceHistory() {
        return raceHistory;
    }

    public List<Car> getWinner() {
        return raceHistory.get(raceHistory.size() - 1)
                .getWinner();
    }
}
