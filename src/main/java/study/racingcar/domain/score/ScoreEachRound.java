package study.racingcar.domain.score;

import java.util.List;
import java.util.Objects;

public class ScoreEachRound {
    private final List<Score> roundScores;

    public ScoreEachRound(List<Score> roundScores) {
        this.roundScores = roundScores;
    }

    public List<Score> roundScores(){
        return this.roundScores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScoreEachRound that = (ScoreEachRound) o;
        return Objects.equals(roundScores, that.roundScores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundScores);
    }
}
