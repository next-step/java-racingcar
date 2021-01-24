package racingcar.domain;

public class SecondCarForwardMovementCondition extends MovementCondition {

    private final boolean[] conditions = {false, true, false};
    private int repeat = 0;

    @Override
    public boolean satisfies() {
        return conditions[repeat++ % 3];
    }
}
