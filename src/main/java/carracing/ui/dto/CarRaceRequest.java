package carracing.ui.dto;

import carracing.domain.car.RaceCars;
import carracing.domain.race.Race;

import java.util.ArrayList;
import java.util.List;

public class CarRaceRequest {
    private final List<String> carNames = new ArrayList<>();
    private final int movingCount;

    public CarRaceRequest(List<String> carNames, int movingCount) {
        this.carNames.addAll(carNames);
        this.movingCount = movingCount;
    }

    public Race toCarRace() {
        return new Race(RaceCars.makeCars(carNames));
    }

    public Integer getMovingCount() {
        return movingCount;
    }
}
