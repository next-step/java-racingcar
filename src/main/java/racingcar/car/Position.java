package racingcar.car;

import racingcar.util.Util;

public class Position {
    private int position;
    private static final int FORWARD_DISTANCE = 1;

    public Position(int position) {
        this.position = position;
    }

    public void movePosition() {
        if (isMovable(Util.generateRandom())) {
            moveForward();
        }
    }

    private boolean isMovable(int number) {
        return number >= 4;
    }

    private void moveForward() {
        this.position += FORWARD_DISTANCE;
    }

    public int getPosition() {
        return position;
    }
}
