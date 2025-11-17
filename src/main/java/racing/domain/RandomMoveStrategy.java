package racing.domain;

public class RandomMoveStrategy implements MoveStrategy {

    private static final String INVALID_RANDOM_RANGE_MESSAGE = "랜덤 값이 0과 9 사이여야 합니다.";
    private static final int MOVE_THRESHOLD = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

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
        if (isOutOfRange(number)) {
            throw new RuntimeException(INVALID_RANDOM_RANGE_MESSAGE);
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER;
    }
}
