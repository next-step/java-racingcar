package carracing.logic.type;

import java.util.Objects;

public class Score {
    private final int value;

    public Score(int value) {
        this.value = vaild(value);
    }

    private int vaild(int value) {
        return  (0<= value && value<=9) ? value : () -> throw new RuntimeException("Score 는 0이상 9이하의 값을 가질 수 있습니다");
    }

    public int toInt() {
        return value;
    }

    public String toProgress() {
        return value > 4 ? "-" : "";
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
