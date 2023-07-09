package racingcar.domain.Car;

import java.util.Objects;

public class Score {

    private static final int SCORE_INCREMENT = 1;
    private static final int MIN_SCORE = 0;
    private final int score;

    public Score(final int score) {
        validate(score);
        this.score = score;
    }

    private void validate(final int score) {
        if (score < MIN_SCORE) {
            throw new RuntimeException("score는 음수가 될 수 없습니다");
        }
    }

    public int get() {
        return score;
    }

    public Score increase() {
        return new Score(score + SCORE_INCREMENT);
    }

    public boolean isSameScore(final int score) {
        return this.score == score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return score == score1.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
