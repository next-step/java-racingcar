package racingcar.car;

import racingcar.util.Util;
import racingcar.view.ResultView;

public class Position {
    private int position;

    public static final int FORWARD_DISTANCE = 1;

    public Position() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
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

    public void printCarPosition() {
        ResultView.printCarPosition(this.position);
    }


}
