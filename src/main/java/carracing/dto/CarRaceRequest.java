package carracing.dto;

import carracing.Cars;
import carracing.CarRace;

import java.util.ArrayList;
import java.util.List;

public class CarRaceRequest {
    private final List<String> carNames = new ArrayList<>();
    private final int movingCount;

    public CarRaceRequest(List<String> carNames, int movingCount) {
        this.carNames.addAll(carNames);
        this.movingCount = movingCount;
    }

    public CarRace toCarRace() {
        return new CarRace(Cars.makeCars(carNames));
    }

    public Integer getMovingCount() {
        return movingCount;
    }
}
