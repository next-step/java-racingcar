package racing;

public class Car {
    private static final int MOVEMENT_THRESHOLD = 4;
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void goForward(int value) {
        if (value >= MOVEMENT_THRESHOLD) {
            position++;
        }
    }
}
