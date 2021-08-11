package race;

import java.util.Random;

public class RandomNum {

    protected static final Random random = new Random();

    protected static int getRandomNum() {
        return random.nextInt(10);
    }
}
