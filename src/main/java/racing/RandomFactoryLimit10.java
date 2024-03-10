package racing;

import java.util.Random;

public class RandomFactoryLimit10 implements RandomFactory {

    private static final int MAX_LIMIT = 10;

    @Override
    public int getNextInt() {
        Random random = new Random();
        return random.nextInt(MAX_LIMIT);
    }
}
