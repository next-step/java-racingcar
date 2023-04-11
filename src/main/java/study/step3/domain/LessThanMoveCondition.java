package study.step3.domain;

public class LessThanMoveCondition implements MoveConditionStrategy {

    private final int criteria;

    public LessThanMoveCondition(int criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean isPossible(int distance) {
        if (distance >= criteria) {
            return true;
        }
        return false;
    }

}
