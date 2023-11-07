package racing.model;

import java.util.Random;

public class RacingCar {
    public static final int CAN_I_MOVE = 4;

    private final Random random = new Random();
    private int progress;

    public RacingCar(int progress) {
        this.progress = progress;
    }

    public void race(int randomValue){
        if (randomValue < CAN_I_MOVE) {
            return;
        }
        this.progress++;
    }

    public int getProgress() {
        return progress;
    }

    public int getRandomInt(){
        return random.nextInt(10);
    }

}
