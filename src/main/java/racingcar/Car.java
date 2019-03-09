package racingcar;

public class Car {
    public static final int MOVE_THRESHOLD = 3;
    private int movedDistance = 0;

    public void go() {
        this.movedDistance++;
    }

    public boolean goWhenGreaterThanThreshold(int value) {
        if (MOVE_THRESHOLD < value) {
            go();
            return true;
        }

        return false;
    }

    public void showMovedDistance() {
        StringBuilder visualizedMovedDitance = new StringBuilder();

        for (int i = 0; i < this.movedDistance; i++) {
            visualizedMovedDitance.append("-");
        }

        System.out.println(visualizedMovedDitance);
    }

    public int getMovedDistance() {
        return this.movedDistance;
    }
}
