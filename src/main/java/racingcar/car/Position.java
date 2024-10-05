package racingcar.car;

import racingcar.exception.GameException;

public class Position {

    private final int position;

    private Position(int position) {
        if (position < 0) {
            throw new GameException("음수를 허용하지 않습니다.");
        }
        this.position = position;
    }

    public static Position of(int currentLocation) {
        return new Position(currentLocation);
    }

    public Position add() {
        return new Position(position + 1);
    }

    public int getPosition() {
        return position;
    }

    public boolean isSame(int position) {
        return this.position == position;
    }

    public int max(int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }
}
