package domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    List<Integer> carPositions;
    List<RacingCarCurrentStatus> raceProgress;

    public RoundResult(List<RacingCar> cars) {
        this.raceProgress = new ArrayList<>();
        for (RacingCar car : cars) {
            RacingCarCurrentStatus currentStatus = car.getCurrentStatus();
            raceProgress.add(currentStatus);
        }
    }

    public List<Integer> whereAreCars() {
        return this.carPositions;
    }

    public List<RacingCarCurrentStatus> getRaceProgress() {
        return raceProgress;
    }
}
