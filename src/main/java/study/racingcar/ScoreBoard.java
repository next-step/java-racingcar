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
        grids.forEach(scoreEachRound -> {
            if (result.isEmpty()) {
                result.add(
                    scoreEachRound.roundScores().stream()
                        .collect(Collectors.toMap(Score::whozScore,
                            score -> String.valueOf(score.score().moveString()))));
                return;
            }
            Map<Car, String> last = result.getLast();
            result.add(scoreEachRound.roundScores().stream()
                .map(score -> Map.entry(score.whozScore(),
                    last.get(score.whozScore()) + score.score().moveString()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        });
        return result;
    }

}
