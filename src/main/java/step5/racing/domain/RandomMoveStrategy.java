package step5.racing.domain;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final NumberGenerator numberGenerator;

    public RandomMoveStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        int number = numberGenerator.generate();
        validateRange(number);
        return number >= MOVE_THRESHOLD;
    }

    private void validateRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException();
        }
    }
}
