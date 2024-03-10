package racing;

import java.util.Random;

public class RandomFactory {

    private static final int MAX_LIMIT = 10;

    public int getNextInt() {
        Random random = new Random();
        return random.nextInt(MAX_LIMIT);
    }
}
