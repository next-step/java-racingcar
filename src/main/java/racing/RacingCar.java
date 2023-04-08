package racing;

import java.util.Random;

public class RacingCar {
    private final int MAX_RANDOM_VALUE = 9;
    private final int THRESHOLD_ONGOING = 4;

    private final Random rnd = new Random();
    private int numberOfOngoing;

    public int getNumberOfOngoing() {
        return numberOfOngoing;
    }

    public RacingCar() {
        this.numberOfOngoing = 0;
    }

    private int random() {
        return rnd.nextInt(this.MAX_RANDOM_VALUE + 1);
    }

    private boolean isOngoing() {
        return random() >= this.THRESHOLD_ONGOING;
    }

    public void ongoing() {
        if (isOngoing()) {
            numberOfOngoing++;
        }
    }
}
