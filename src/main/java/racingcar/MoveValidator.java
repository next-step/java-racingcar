package racingcar;

public final class MoveValidator {
    private static final int MOVE_BOUNDARY_NUMBER = 4;
    private final RandomGenerator randomGenerator;

    public MoveValidator() {
        this.randomGenerator = new RandomGenerator();
    }

    public boolean validate() {
        int number = randomGenerator.generateNumber();
        if (number >= MOVE_BOUNDARY_NUMBER) {
            return true;
        }
        return false;
    }
}
