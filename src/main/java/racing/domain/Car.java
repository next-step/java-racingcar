package racing.domain;

public class Car {

    private static final String INVALID_RANDOM_RANGE_MESSAGE = "랜덤 값이 0과 9 사이여야 합니다.";
    private static final int DEFAULT_POSITION = 0;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVE_THRESHOLD = 4;

    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public void move(int number) {
        validateNumber(number);

        if (canMove(number)) {
            position++;
        }
    }

    private void validateNumber(int number) {
        if (isOutOfRange(number)) {
            throw new RuntimeException(INVALID_RANDOM_RANGE_MESSAGE);
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER;
    }

    private boolean canMove(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }
}
