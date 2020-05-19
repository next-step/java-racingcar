package step3;

public class RacingCar {
    private static final int POWER_THRESHOLD = 4;
    private static final int INIT_POSITION = 0;
    private static final int MOVE_DISTANCE = 1;

    private int currentPosition = INIT_POSITION;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(int power) {
        if(inputPowerCehck(power)) {
            this.currentPosition += MOVE_DISTANCE;
        }
    }

    private boolean inputPowerCehck(int power) {
        return power >= POWER_THRESHOLD;
    }
}

