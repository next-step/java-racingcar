package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundResults {
    private final List<RoundResult> roundResults = new ArrayList<>();

    public void recordResults(List<Integer> currentPositions) {
        roundResults.add(new RoundResult(currentPositions));
    }

    public List<List<Integer>> getResults() {
        return roundResults.stream()
                .map(RoundResult::getResults)
                .collect(Collectors.toList());
    }
}
