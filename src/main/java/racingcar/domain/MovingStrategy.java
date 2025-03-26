package racingcar.domain;

public class MovingStrategy {

    private final int movableMinNumberThreshold;
    private final int DEFAULT_MOVABLE_MIN_NUMBER_THRESHOLD = 4;
    private final int MIN_NUMBER_BOUND = 0;
    private final int MAX_NUMBER_BOUND = 9;

    public MovingStrategy() {
        this.movableMinNumberThreshold = DEFAULT_MOVABLE_MIN_NUMBER_THRESHOLD;
    }

    public MovingStrategy(int movableMinNumberThreshold) {
        checkValidNumber(movableMinNumberThreshold);
        this.movableMinNumberThreshold = movableMinNumberThreshold;
    }

    public boolean isMoving(int number) {
        checkValidNumber(number);
        return movableMinNumberThreshold <= number;
    }

    private void checkValidNumber(int number) {
        if (number < MIN_NUMBER_BOUND || number > MAX_NUMBER_BOUND) {
            throw new IllegalArgumentException(
                    String.format("%d 이상 %d 이하 숫자만 입력하셔야 합니다.", MIN_NUMBER_BOUND, MAX_NUMBER_BOUND)
            );
        }
    }

}
