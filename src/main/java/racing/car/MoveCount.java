package racing.car;

public class MoveCount {
    private static final Integer MIN_NUMBER_OF_MOVES = 0;
    private final int count;

    public MoveCount(int count) {
        if (count <= MIN_NUMBER_OF_MOVES) {
            throw new IllegalArgumentException("이동 횟수는 0보다 커야 합니다.");
        }

        this.count = count;
    }

    public boolean isUnderCount(int round) {
        return this.count > round;
    }
}
