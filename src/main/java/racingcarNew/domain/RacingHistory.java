package racingcarNew.domain;

import java.util.List;

public class RacingHistory {

    private List<Cars> carsHistory;

    public RacingHistory(List<Cars> carsHistory) {
        this.carsHistory = carsHistory;
    }

    public List<Cars> getCarsHistory() {
        return this.carsHistory;
    }

    public Cars getLastCarsHistory(int racingLap) {
        return carsHistory.get(racingLap - 1);
    }
}
