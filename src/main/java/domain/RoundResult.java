package domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    List<RacingCarCurrentStatus> raceProgress;

    public RoundResult(RacingCars cars) {
        this.raceProgress = cars.listCurrentRacingCarStatuses();
    }

    public List<RacingCarCurrentStatus> getRaceProgress() {
        return raceProgress;
    }
}
