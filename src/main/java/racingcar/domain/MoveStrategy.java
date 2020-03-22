package racingcar.domain;

public class MoveStrategy {

    private final int randomValue;

    public MoveStrategy(int randomValue) {
        this.randomValue = randomValue;
    }

    public boolean isMove() {
        return randomValue >= RacingGameConstant.MOVE_CONDITION;
    }

}
