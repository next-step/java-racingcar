package step3.domain;

import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CarRacingGameResult {

    private static final String NAME_DELIMITER = ",";

    private List<Round> playedRounds;

    public CarRacingGameResult(List<Round> playedRounds) {
        this.playedRounds = playedRounds;
    }

    public String getWinnerNames() {

        List<CarRunResult> finalRoundResult = getFinalRoundCarRunResult();

        List<CarRunResult> winnerResults = findWinnerResults(finalRoundResult);

        return joiningWinnerNames(winnerResults);
    }

    private List<CarRunResult> findWinnerResults(List<CarRunResult> finalRoundResult) {
        return finalRoundResult.stream()
            .collect(groupingBy(CarRunResult::getRunDistance))
            .entrySet()
            .stream()
            .max(Entry.comparingByKey())
            .get()
            .getValue();
    }

    private String joiningWinnerNames(List<CarRunResult> winnerResults) {
        return winnerResults.stream()
            .map(CarRunResult::getCarNameString)
            .collect(Collectors.joining(NAME_DELIMITER));
    }

    private List<CarRunResult> getFinalRoundCarRunResult() {
        Round finalRound = playedRounds.get(playedRounds.size() - 1);
        return finalRound.getCarRunResults();
    }

    public List<Round> getPlayedRounds() {
        return playedRounds;
    }

    public void addRound(Round round) {
        playedRounds.add(round);
    }
}
