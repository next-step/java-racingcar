package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Scores {

    private final List<Score> scores;

    public Scores() {
        scores = new ArrayList<>();
    }

    public void addScore(Score score) {
        scores.add(score);
    }

    public List<Score> getScores() {
        return scores;
    }
}
