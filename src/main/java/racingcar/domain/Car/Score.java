package racingcar.domain;

import java.util.Objects;

public class Score {
    private final int score;

    public Score(int score) {
        validate(score);
        this.score = score;
    }

    private void validate(int score) {
        if (score < 0) {
            throw new RuntimeException("score는 음수가 될 수 없습니다");
        }
    }

    public int getScore() {
        return score;
    }

    public Score increase() {
        return new Score(score + 1);
    }

    public boolean isSameScore(int maxScore) {
        return score == maxScore;
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
