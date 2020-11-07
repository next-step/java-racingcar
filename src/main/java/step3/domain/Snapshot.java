package step3.domain;

import java.util.List;

public class Snapshot {
    private final List<CarRacingResult> carRacingResults;

    private Snapshot(final List<CarRacingResult> carRacingResults) {
        this.carRacingResults = carRacingResults;
    }

    public static Snapshot of(final List<CarRacingResult> carRacingResults) {
        return new Snapshot(carRacingResults);
    }

    public List<CarRacingResult> getCarRacingResults() {
        return carRacingResults;
    }
}
