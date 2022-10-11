package nextstep.javaracingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRacingResult {

    private final List<CarDrivingResult> drivingResults;

    public CarRacingResult(final List<CarDrivingResult> drivingResults) {
        this.drivingResults = drivingResults;
    }

    public List<CarDrivingResult> winners() {

        Distance maxDistance = Distance.ZERO;
        for (CarDrivingResult drivingResult : drivingResults) {
            maxDistance = drivingResult.maxDistance(maxDistance);
        }

        final List<CarDrivingResult> winners = new ArrayList<>();
        for (CarDrivingResult drivingResult : drivingResults) {
            if (drivingResult.isPosition(maxDistance)) {
                winners.add(drivingResult);
            }
        }
        return winners;
    }
}
