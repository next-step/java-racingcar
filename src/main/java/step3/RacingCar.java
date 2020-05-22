package step3;

import java.util.List;

public class RacingCar {
    private static final int POWER_THRESHOLD = 4;
    private static final int MOVE_DISTANCE = 1;

    private int currentPosition;
    private String carName;

    public RacingCar(String inputCarName) {
        this.carName = inputCarName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getCarName() {
        return carName;
    }

    public void move(int power) {
        if (checkPowerThreshold(power)) {
            this.currentPosition += MOVE_DISTANCE;
        }
    }

    private boolean checkPowerThreshold(int power) {
        return power >= POWER_THRESHOLD;
    }

    public void getWinners(List<String> WinnersClub, int maxPosition) {
        if (maxPosition == currentPosition) {
            WinnersClub.add(carName);
        }
    }

}

