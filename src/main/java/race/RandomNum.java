package race;

import java.util.Random;

public class RandomNum {

    protected static int getRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
