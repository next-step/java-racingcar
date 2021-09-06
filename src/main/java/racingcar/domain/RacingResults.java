package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResults {

    private List<RacingResult> racingResults;

    public RacingResults(RacingCars racingCars) {
        this.racingResults = racingCars.getRacingCars()
                .stream()
                .map(racingCar -> new RacingResult(racingCar.getName(), racingCar.getPosition()))
                .collect(Collectors.toList());
    }

    public List<RacingResult> getRacingResults() {
        return racingResults;
    }

}
