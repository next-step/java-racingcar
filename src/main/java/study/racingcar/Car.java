package study.racingcar;

public class Car {

    private final RandomGenerator randomGenerator;

    private static final int MOVE_CONDITION = 4;

    public Car(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    private int pickRandomValue() {
        return randomGenerator.number();
    }

    public void run() {

    }
}
