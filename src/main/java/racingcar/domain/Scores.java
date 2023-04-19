package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scores {

    private final List<Score> scores;

    public Scores() {
        scores = new ArrayList<>();
    }

    public void addScore(Car car) {
        Score score = new Score(car.findCarPoint());
        scores.add(score);
    }

    public List<Score> findAllScores() {
        return Collections.unmodifiableList(scores);
    }
}
