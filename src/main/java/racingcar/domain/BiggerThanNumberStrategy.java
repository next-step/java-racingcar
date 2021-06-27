package racingcar.domain;

public class BiggerThanNumberStrategy implements MovableStrategy {
    private static final int MOVABLE_CONDITION = 4;

    @Override
    public boolean isMove() {
        return RandomNumber.createRandomNumber() >= MOVABLE_CONDITION;
    }
}
