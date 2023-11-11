package study.racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import study.racingcar.view.ScoreBoardView;

public class ScoreBoardResult {

    public History history(ScoreBoard scoreBoard) {
        return new History(makingResult(scoreBoard.grids()));
    }


    private LinkedList<Map<Car,String>> makingResult(List<ScoreEachRound> grids) {
        LinkedList<Map<Car,String>> resultList = new LinkedList<>();
        grids.forEach(scoreEachRound -> {
            if (resultList.isEmpty()) {
                firstRoundResult(resultList, scoreEachRound);
                return;
            }
            firstAfterRoundResult(resultList, scoreEachRound);
        });
        return resultList;
    }

    private void firstAfterRoundResult(LinkedList<Map<Car,String>> resultList, ScoreEachRound scoreEachRound) {
        Map<Car, String> last = resultList.getLast();
        resultList.add(scoreEachRound.roundScores().stream().map(score -> {
            return Map.entry(score.whozScore(),
                last.get(score.whozScore()) + ScoreBoardView.scoreToString(score.scoreMoveStatus()));
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    private void firstRoundResult(LinkedList<Map<Car,String>> resultList, ScoreEachRound scoreEachRound) {
        resultList.add(scoreEachRound.roundScores().stream().collect(Collectors.toMap(Score::whozScore,
            score -> ScoreBoardView.scoreToString(score.scoreMoveStatus()))));
    }

}
