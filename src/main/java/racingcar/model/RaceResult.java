package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    private final List<Car> raceResultByRound;

    public RaceResult(List<Car> raceResult) {
        this.raceResultByRound = new ArrayList<>(raceResult);
    }

    public List<Car> getRaceResultByRound() {
        return raceResultByRound;
    }
}
