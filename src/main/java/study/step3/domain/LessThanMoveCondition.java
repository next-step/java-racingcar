package study.step3.domain;

public class LessThanMoveCondition implements MoveConditionStrategy {

    private int criteria;
    private MoveStrategy moveStrategy;

    public LessThanMoveCondition(int criteria, MoveStrategy moveStrategy) {
        this.criteria = criteria;
        this.moveStrategy = moveStrategy;
    }

    @Override
    public boolean isPossible() {
        return moveStrategy.createMove() >= criteria;
    }

}
