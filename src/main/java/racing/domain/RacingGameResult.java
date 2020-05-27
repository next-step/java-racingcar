package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private final List<RacingCars> allRoundRacingCars;

    public RacingGameResult() {
        allRoundRacingCars = new ArrayList<>();
    }

    public void addResult(RacingCars racingCars) {
        allRoundRacingCars.add(racingCars);
    }

    public List<RacingCars> getAllRoundRacingCars() {
        return allRoundRacingCars;
    }

    public String getWinners() {
        return null;
    }
}
