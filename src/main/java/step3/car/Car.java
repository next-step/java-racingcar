package step3.car;

public class Car {

    private static final int STAY_THRESHOLD = 3;
    private static final String MOVED_MARKER = "-";

    private int movedDistance = 0;

    public void tryMove(int randomValue) {
        if (isMoveCondition(randomValue))
            move();
    }

    private boolean isMoveCondition(int value) {
        return value > STAY_THRESHOLD;
    }

    private void move() {
        movedDistance++;
    }

    public String getMovedDistance() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < movedDistance; i++) {
            sb.append(MOVED_MARKER);
        }
        return sb.toString();
    }
}
