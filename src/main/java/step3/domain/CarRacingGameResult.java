package step3.domain;

import static java.util.stream.Collectors.groupingBy;

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

        Round finalRound = getFinalRound();

        List<CarRunResult> winnerResults = findWinnerResultsFromRound(finalRound);

        return generateWinnerNames(winnerResults);
    }

    private List<CarRunResult> findWinnerResultsFromRound(Round round) {
        List<CarRunResult> carRunResults = round.getCarRunResults();

        return carRunResults.stream()
            .collect(groupingBy(CarRunResult::getRunDistance))
            .entrySet()
            .stream()
            .max(Entry.comparingByKey())
            .get()
            .getValue();
    }

    private String generateWinnerNames(List<CarRunResult> winnerResults) {
        return winnerResults.stream()
            .map(CarRunResult::getCarNameString)
            .collect(Collectors.joining(NAME_DELIMITER));
    }

    public Round getFinalRound() {
        return playedRounds.get(playedRounds.size() - 1);
    }

    public List<Round> getPlayedRounds() {
        return playedRounds;
    }

    public int getPlayedRoundsCount() {
        return playedRounds.size();
    }

    public void addRound(Round round) {
        playedRounds.add(round);
    }
}
