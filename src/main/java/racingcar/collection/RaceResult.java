package racingcar.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private final List<Winner> winners = new ArrayList<>();
    private final List<LapResult> labResults = new ArrayList<>();

    public void addRaceResult(LapResult result) {
        labResults.add(result);
    }

    public List<LapResult> getLabResults() {
        return labResults;
    }

    public void addWinner(Winner winner) {
        this.winners.add(winner);
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Winner::getName)
                .collect(Collectors.toList());
    }
}
