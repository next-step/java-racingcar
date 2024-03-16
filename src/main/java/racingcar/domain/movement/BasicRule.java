package racingcar.domain.movement;

import static racingcar.config.RacingCarException.MOVEMENT_CONDITION_OUT_OF_RANGE;

public class BasicRule implements Rule {

    public static final int MINIMUM_CONDITION = 0;
    public static final int FORWARD_CONDITION = 4;
    public static final int MAXIMUM_CONDITION = 9;

    @Override
    public boolean movable(final int condition) {
        validateConditionIsInRange(condition);

        return condition >= FORWARD_CONDITION;
    }

    private void validateConditionIsInRange(final int condition) {
        if (isConditionOutOfRange(condition)) {
            throw new IllegalArgumentException(MOVEMENT_CONDITION_OUT_OF_RANGE.message(condition));
        }
    }

    private boolean isConditionOutOfRange(final int condition) {
        return condition < MINIMUM_CONDITION || condition > MAXIMUM_CONDITION;
    }
}
