package car.domain.condition;

import car.utils.RandomUtils;

public class RandomConditionImpl implements RacingCondition {

    private static final int VALUE = 10;
    private static final int SATISFIED_VAL = 4;

    @Override
    public boolean isSatisfied() {
        return SATISFIED_VAL <= RandomUtils.getRandomValueLesserThen(VALUE);
    }
}
