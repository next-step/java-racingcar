package racingcar.domain;

import java.util.Objects;

public class Score {
    private int value;

    Score() {
        this.value = 0;
    }

    Score(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    Score getAddedScore() {
        return new Score(this.value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
