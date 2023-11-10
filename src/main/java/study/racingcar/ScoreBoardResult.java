package study.racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import study.racingcar.view.ScoreBoardView;

public class ScoreBoardResult {

    public static ScoreBoardResult create() {
        return new ScoreBoardResult();
    }

    public LinkedList<Map<Car, String>> result(ScoreBoard scoreBoard){
        LinkedList<Map<Car, String>> result = new LinkedList<>();
        makingResult(scoreBoard.grids(), result);
        return result;
    }

    private void makingResult(List<ScoreEachRound> grids, LinkedList<Map<Car, String>> result) {
        grids.forEach(scoreEachRound -> {
            if (result.isEmpty()) {
                firstRoundResult(scoreEachRound, result);
                return;
            }
            firstAfterRoundResult(scoreEachRound, result);
        });
    }

    private void firstAfterRoundResult(ScoreEachRound scoreEachRound, LinkedList<Map<Car, String>> result) {
        Map<Car, String> last = result.getLast();
        result.add(scoreEachRound.roundScores().stream().map(score -> {
                return Map.entry(score.whozScore(), last.get(score.whozScore()) + ScoreBoardView.scoreToString(score.scoreMoveStatus()));
            })
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    private void firstRoundResult(ScoreEachRound scoreEachRound, LinkedList<Map<Car, String>> result) {
        result.add(
            scoreEachRound.roundScores().stream()
                .collect(Collectors.toMap(Score::whozScore, score -> ScoreBoardView.scoreToString(score.scoreMoveStatus()))));
    }


}
