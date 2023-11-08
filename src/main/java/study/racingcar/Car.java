package study.racingcar;

public class Car {

    private static final int MOVE_CONDITION = 4;

    public MoveStatus canMove(RandomGenerator randomGenerator) {
        if (pickRandomValue(randomGenerator) >= MOVE_CONDITION) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }

    private int pickRandomValue(RandomGenerator randomGenerator) {
        return randomGenerator.number();
    }

}
