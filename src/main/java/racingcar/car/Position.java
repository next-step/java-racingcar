package racingcar.car;

import racingcar.util.ValidationUtil;

import java.util.concurrent.atomic.AtomicInteger;


public class Position {
    private AtomicInteger position;

    public static int defaultDistance = 0;
    public static int forwardDistance = 1;

    public Position() {
        this.position = new AtomicInteger();
    }

    public int getPosition() {
        return position.get();
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public void setPosition(int position) {
        ValidationUtil.validatePosition(position);
        this.position.accumulateAndGet(position, (x, y) -> (x + y));
    }

    public void moveForward() {
        setPosition(forwardDistance);
    }
}
