package study.firstweek.secondstep;

import java.util.Random;

public class NumberGenerator {

    private final Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(10);
    }
}
