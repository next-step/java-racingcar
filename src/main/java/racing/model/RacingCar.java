package racing.model;

import java.util.Random;

public class RacingCar {
    public static final int CAN_I_MOVE = 4;

    private final Random random = new Random();
    private int progress;
    private String name;

    public RacingCar(int progress, String name) {
        this.progress = progress;
        this.name = name;
    }

    public void race(int randomValue) {
        if (randomValue < CAN_I_MOVE) {
            return;
        }
        this.progress++;
    }

    public int getProgress() {
        return this.progress;
    }

    public String getName() {
        return this.name;
    }

    public int getRandomInt() {
        return random.nextInt(10);
    }

}
