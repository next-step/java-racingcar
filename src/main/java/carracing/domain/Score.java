package carracing.domain;

import java.util.Objects;
import java.util.function.IntUnaryOperator;

import static carracing.common.ScoreSupport.FORWARD_MARK;
import static carracing.common.ScoreSupport.SCORE_THRESHOLD;
import static carracing.common.ScoreSupport.STOP_MARK;

public class Score {
    private static final IntUnaryOperator validate = value -> {
        if (0 <= value && value <= 9) {
            return value;
        }
        throw new RuntimeException("Score 는 0 이상 9 이하의 값을 가질 수 있습니다");
    };
    private final int value;

    public Score(int value) {
        this.value = validate.applyAsInt(value);
    }

    public int getValue() {
        return value;
    }

    public String render() {
        return value >= SCORE_THRESHOLD ? FORWARD_MARK : STOP_MARK;
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
