package racingcar.domain;

import racingcar.utils.RandomUtils;

public class Car {
    private int position = 0;
    private final int MAX_ACTION_INT = 9;
    private final int STOP_LIMIT = 4;

    public int getPosition() {
        return this.position;
    }

    public void goForward() {
        position++;
    }

    public void act() {
        if (decideAction(RandomUtils.getRandomPositiveInt(MAX_ACTION_INT)) == CarAction.GO_FORWARD) {
            goForward();
        }
    }

    public CarAction decideAction(int actionNo) {
        if (actionNo < STOP_LIMIT) {
            return CarAction.STOP;
        }
        return CarAction.GO_FORWARD;
    }
}
