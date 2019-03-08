package racingcar;

import java.util.Random;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private int movedDistance = 0;

    public void go() {
        this.movedDistance++;
    }

    public int getMovedDistance() {
        return this.movedDistance;
    }

    public boolean randomlyGo() {
        if (canGo()) {
            go();
            return true;
        }

        return false;
    }

    private boolean canGo() {
        return MOVE_THRESHOLD < new Random().nextInt(10);
    }

    public void showMovedDistance() {
        StringBuilder visualizedMovedDitance = new StringBuilder();

        for (int i = 0; i < this.movedDistance; i++) {
            visualizedMovedDitance.append("-");
        }

        System.out.println(visualizedMovedDitance);
    }
}
