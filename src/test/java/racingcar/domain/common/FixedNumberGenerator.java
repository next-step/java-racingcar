package racingcar.domain.common;

public class FixedNumberGenerator implements NumberGenerator {
    private static final int MOVE_CONDITION_NUMBER = 4;

    @Override
    public int generateNumber() {
        return MOVE_CONDITION_NUMBER;
    }
}
