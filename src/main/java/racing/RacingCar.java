package racing;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    private final static String ICON = "-";

    private final Random random = new Random();
    private final StringBuilder progress;

    public RacingCar(StringBuilder progress) {
        this.progress = progress;
    }

    public void race(){
        if (getRandomInt() < 4) {
            return;
        }
        this.progress.append(ICON);
    }

    public int getRandomInt(){
        return random.nextInt(10);
    }

    public StringBuilder getProgress() {
        return progress;
    }
}
