package racingcar.logic;

public class Position {
    private static String NEGATIVE_POSITION_MESSAGE = "음수 포지션은 존재할 수 없습니다.";
    private static int MOVE_AMOUNT = 1;

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position valueOf(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(NEGATIVE_POSITION_MESSAGE);
        }
        return new Position(position);
    }

    public Position move() {
        return Position.valueOf(this.position + MOVE_AMOUNT);
    }

    public int getPosition() {
        return this.position;
    }
}
