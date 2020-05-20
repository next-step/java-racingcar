package step3;

public class RacingCar {
    private static final int POWER_THRESHOLD = 4;
    private static final int MOVE_DISTANCE = 1;

    private int currentPosition;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(int power) {
        if(checkPowerThreshold(power)) {
            this.currentPosition += MOVE_DISTANCE;
        }
    }

    private boolean checkPowerThreshold(int power) {
        return power >= POWER_THRESHOLD;
    }
}

