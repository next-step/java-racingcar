package racingcar;

import java.util.Random;

public class Car {
    private int movedDistance;

    public void go() {
        this.movedDistance++;
    }

    public int getMovedDistance() {
        return this.movedDistance;
    }

    public boolean randomlyGo() {
        if (4 < new Random().nextInt(10)) {
            go();
            return true;
        }

        return false;
    }

}
