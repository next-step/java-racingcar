package racing;

public class Car {
    private static final String DASH = "-";
    private static final int MOVEMENT_THRESHOLD = 4;
    private int position = 1;

    public String positionInfoString() {
        return DASH.repeat(position);
    }

    public void goForward(int value) {
        if (value >= MOVEMENT_THRESHOLD) {
            position++;
        }
    }
}
