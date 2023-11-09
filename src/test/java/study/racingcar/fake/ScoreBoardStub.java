package study.racingcar.fake;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import study.racingcar.Car;
import study.racingcar.Score;
import study.racingcar.ScoreBoard;
import study.racingcar.ScoreEachRound;

public class ScoreBoardStub extends ScoreBoard {

    private List<ScoreEachRound> fakeScores;

    public ScoreBoardStub() {
        this.fakeScores = new ArrayList<>();
    }

    @Override
    public void score(ScoreEachRound scoreEachRound) {
        fakeScores.add(scoreEachRound);
    }

    public List<Map<Car, String>> scores() {
        LinkedList<Map<Car, String>> result = new LinkedList<>();
        fakeScores.forEach(scoreEachRound -> {
            if (result.isEmpty()) {
                result.add(
                    scoreEachRound.roundScores().stream()
                        .collect(Collectors.toMap(Score::whozScore, score -> String.valueOf(score.score()))));
                return;
            }
            Map<Car, String> last = result.getLast();
            result.add(scoreEachRound.roundScores().stream()
                .map(score -> Map.entry(score.whozScore(), last.get(score.whozScore()) + score.score()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        });
        return result;
    }
}
