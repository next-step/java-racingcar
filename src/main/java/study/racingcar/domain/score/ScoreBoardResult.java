package study.racingcar.domain.score;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import study.racingcar.domain.history.History;
import study.racingcar.domain.car.Car;
import study.racingcar.util.MoveStatus;

public class ScoreBoardResult {

    public History history(ScoreBoard scoreBoard) {
        return new History(makingResult(scoreBoard.grids()));
    }


    private LinkedList<Map<Car, Integer>> makingResult(List<ScoreEachRound> grids) {
        LinkedList<Map<Car, Integer>> resultList = new LinkedList<>();
        grids.forEach(scoreEachRound -> {
            if (resultList.isEmpty()) {
                firstRoundResult(resultList, scoreEachRound);
                return;
            }
            firstAfterRoundResult(resultList, scoreEachRound);
        });
        return resultList;
    }

    private void firstAfterRoundResult(LinkedList<Map<Car, Integer>> resultList,
        ScoreEachRound scoreEachRound) {
        Map<Car, Integer> last = resultList.getLast();
        resultList.add(scoreEachRound.roundScores().stream().map(score -> {
            return Map.entry(score.whozScore(), addScore(score, last));
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    private static int addScore(Score score, Map<Car, Integer> last) {
        return last.get(score.whozScore()) + getScorePoint(score);
    }

    private void firstRoundResult(LinkedList<Map<Car, Integer>> resultList,
        ScoreEachRound scoreEachRound) {
        resultList.add(
            scoreEachRound.roundScores().stream().collect(Collectors.toMap(Score::whozScore,
                ScoreBoardResult::getScorePoint)));
    }

    private static Integer getScorePoint(Score score) {
        if (score.scoreMoveStatus().equals(MoveStatus.MOVE)) {
            return 1;
        }
        return 0;
    }

}
