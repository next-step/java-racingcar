package racingcargamefinal.domain;

public class MoveValue {

    private static final int MOVE_BOUND = 4;

    private final int value;

    public MoveValue(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("move value 는 0 ~ 9입니다.");
        }
    }

    public boolean canMove() {
        return value >= MOVE_BOUND;
    }

}
