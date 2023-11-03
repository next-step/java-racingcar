package study.racingcar;

public class Car {

    private final RandomGenerator randomGenerator;

    private static final int MOVE_CONDITION = 4;
    public Car(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    private int pickRandomeValue() {
        return randomGenerator.number();
    }

    public boolean decideMovement() {
        return pickRandomeValue() >= MOVE_CONDITION;
    }
}
