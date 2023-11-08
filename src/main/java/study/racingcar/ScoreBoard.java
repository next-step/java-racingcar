package study.racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreBoard {

    private final List<ScoreEachRound> grids;

    public ScoreBoard() {
        this.grids = new ArrayList<>();
    }

    public void score(ScoreEachRound scoreEachRound) {
        this.grids.add(scoreEachRound);
    }

    public List<Map<Car, String>> scores() {
        LinkedList<Map<Car, String>> result = new LinkedList<>();
        makeResult(result);
        return result;
    }

    private void makeResult(LinkedList<Map<Car, String>> result) {
        grids.forEach(scoreEachRound -> {
            if (result.isEmpty()) {
                firstRoundResult(result, scoreEachRound);
                return;
            }
            firstAfterRoundResult(result, scoreEachRound);
        });
    }

    private static void firstAfterRoundResult(LinkedList<Map<Car, String>> result,
        ScoreEachRound scoreEachRound) {
        Map<Car, String> last = result.getLast();
        result.add(scoreEachRound.roundScores().stream()
            .map(score -> Map.entry(score.whozScore(),
                last.get(score.whozScore()) + score.score().moveString()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    private static void firstRoundResult(LinkedList<Map<Car, String>> result,
        ScoreEachRound scoreEachRound) {
        result.add(
            scoreEachRound.roundScores().stream()
                .collect(Collectors.toMap(Score::whozScore,
                    score -> String.valueOf(score.score().moveString()))));
    }

}
