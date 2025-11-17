package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceResult {

    private final List<RoundResult> raceResult;

    public RaceResult() {
        this.raceResult = new ArrayList<>();
    }

    public void addResult(RoundResult roundResult) {
        raceResult.add(roundResult);
    }

    public List<RoundResult> getRaceResult() {
        return Collections.unmodifiableList(raceResult);
    }
}
