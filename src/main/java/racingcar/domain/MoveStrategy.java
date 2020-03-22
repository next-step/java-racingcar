package racingcar.domain;

public class MoveStrategy {

    private final boolean condition;

    public MoveStrategy(int randomValue) {
        condition = randomValue >= RacingGameConstant.MOVE_CONDITION;
    }

    public boolean isMove() {
        return condition;
    }

}
