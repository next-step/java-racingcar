package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<List<CarResult>> racingResult = new ArrayList<>();

    public void save(List<CarResult> roundResult) {
        racingResult.add(roundResult);
    }

    public List<List<CarResult>> getRacingResult() {
        return new ArrayList<>(racingResult);
    }

    public List<CarResult> getLastRoundResult() {
        final int lastIndex = racingResult.size() - 1;
        return new ArrayList<>(racingResult.get(lastIndex));
    }
}
