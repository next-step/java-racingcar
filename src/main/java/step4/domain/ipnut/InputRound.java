package step4.domain.ipnut;

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
}
