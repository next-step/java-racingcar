package racingcar;

public class FirstCarForwardMovementCondition extends MovementCondition {

    private final boolean[] conditions = {true, false, false};
    private int repeat = 0;

    @Override
    public boolean satisfies() {
        return conditions[repeat++ % 3];
    }
}
