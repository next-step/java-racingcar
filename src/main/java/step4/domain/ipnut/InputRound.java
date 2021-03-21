package step4.domain.ipnut;

import java.util.Objects;

public final class InputRound {

    private final static int MINIMUM = 0;
    private final int round;

    public InputRound(int round) {
        if (isInvalid(round)) {
            throw new IllegalArgumentException("유효하지 않은 값을 사용했습니다.");
        }
        this.round = round;
    }

    private final boolean isInvalid(int round) {
        return round < MINIMUM;
    }

    public final int inputRound() {
        return round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputRound that = (InputRound) o;
        return round == that.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }

}
