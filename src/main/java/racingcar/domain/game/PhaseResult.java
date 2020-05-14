package racingcar.domain.game;

import java.util.ArrayList;
import java.util.List;

public class PhaseResult {
    private List<Integer> raceResult;

    public PhaseResult(List<Integer> raceResult) {
        this.raceResult = new ArrayList<>(raceResult);
    }

    public List<Integer> getRaceResult() {
        return raceResult;
    }
}
