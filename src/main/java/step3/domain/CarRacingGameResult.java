package step3.domain;

import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CarRacingGameResult {

    private List<Round> playedRounds;

    public CarRacingGameResult(List<Round> playedRounds) {
        this.playedRounds = playedRounds;
    }

    public String getWinnerNames() {

        List<CarRunResult> finalRoundResult = getFinalRoundCarRunResult();

        List<CarRunResult> winnerResults = finalRoundResult.stream()
            .collect(groupingBy(CarRunResult::getRunDistance))
            .entrySet()
            .stream()
            .max(Comparator.comparing(Entry::getKey))
            .get()
            .getValue();

        String winnerNames = winnerResults.stream()
            .map(CarRunResult::getCarNameString)
            .collect(Collectors.joining(","));

        return winnerNames;
    }

    private List<CarRunResult> getFinalRoundCarRunResult() {
        Round finalRound = playedRounds.get(playedRounds.size() - 1);
        return finalRound.getCarRunResults();
    }

    public List<Round> getPlayedRounds() {
        return playedRounds;
    }
}
