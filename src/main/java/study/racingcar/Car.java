package study.racingcar;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private final RandomGenerator randomGenerator;

    public Car(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public MoveStatus canMove() {
        if (pickRandomValue() >= MOVE_CONDITION) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }

    private int pickRandomValue() {
        return randomGenerator.number();
    }

}
