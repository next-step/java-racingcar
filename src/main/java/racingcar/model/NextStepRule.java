package racingcar.model;

public class NextStepRule implements MovementRule {

    private static final int MOVEMENT_RULE_NUMBER = 4;

    @Override
    public boolean meetsRule(int number) {
        return number >= MOVEMENT_RULE_NUMBER;
    }

}
