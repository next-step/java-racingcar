package racingcar.model;

public class OneStepMovePolicy implements MovePolicy {

    private static final Distance STEPS = Distance.ONE;

    @Override
    public Distance getSteps() {
        return STEPS;
    }
}
