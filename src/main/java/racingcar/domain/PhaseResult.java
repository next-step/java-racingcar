package racingcar.domain;

import java.util.List;

public class PhaseResult {
    private List<Integer> raceResult;

    public PhaseResult(List<Integer> raceResult) {
        this.raceResult = raceResult;
    }

    public List<Integer> getRaceResult() {
        return raceResult;
    }
}
