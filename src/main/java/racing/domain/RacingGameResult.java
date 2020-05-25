package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private final List<List<Integer>> allRoundCarsPosition;

    public RacingGameResult() {
        allRoundCarsPosition = new ArrayList<>();
    }

    public void addResult(List<Integer> result) {
        allRoundCarsPosition.add(result);
    }

    public List<List<Integer>> getAllRoundCarsPosition() {
        return allRoundCarsPosition;
    }

}
