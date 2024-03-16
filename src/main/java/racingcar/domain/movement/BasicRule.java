package racingcar.domain.movement;

import static racingcar.config.RacingCarException.MOVEMENT_CONDITION_OUT_OF_RANGE;

public class BasicRule implements Rule {

    private static final String MOVING_CONDITION_OUT_OF_RANGE_MESSAGE = "자동차의 전진/정지 조건은 0이상 9이하의 자연수만 가능합니다. [condition : {0}]";
    private static final int MINIMUM_CONDITION = 0;
    private static final int FORWARD_CONDITION = 4;
    private static final int MAXIMUM_CONDITION = 9;

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
