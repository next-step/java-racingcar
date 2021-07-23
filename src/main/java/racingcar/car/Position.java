package racingcar.car;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Position {
    private AtomicInteger position;
    Random random = new Random();

    public static int forwardDistance = 1;

    public Position() {
        this.position = new AtomicInteger();
    }

    public int getPosition() {
        return position.get();
    }

    public boolean isMove() {
        return random.nextInt(10) >= 4;
    }

    public void setPosition(int position) {
        this.position.accumulateAndGet(position, (x, y) -> (x + y));
    }

    public void moveForward() {
        setPosition(forwardDistance);
    }
}
