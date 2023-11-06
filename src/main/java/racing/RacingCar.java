package racing;

import java.util.Random;

public class RacingCar {
    private final static String ICON = "-";

    private final Random random = new Random();
    private String progress;

    public RacingCar(String progress) {
        this.progress = progress;
    }

    public void race(){
        if (getRandomInt() < 4) {
            return;
        }
        this.progress = this.progress.concat(ICON);
    }

    public int getRandomInt(){
        return random.nextInt(10);
    }

    @Override
    public String toString(){
        return this.progress;
    }
}
