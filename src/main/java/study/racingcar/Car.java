package study.racingcar;

public class Car {

    private final String name;

    private static final int MOVE_CONDITION = 4;

    public Car(String name) {
        this.name = name;
    }

    public MoveStatus canMove(RandomGenerator randomGenerator) {
        if (pickRandomValue(randomGenerator) >= MOVE_CONDITION) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }

    private int pickRandomValue(RandomGenerator randomGenerator) {
        return randomGenerator.number();
    }

    public String name() {
        return this.name;
    }
}
