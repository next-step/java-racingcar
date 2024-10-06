package racinggame.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultRandomNumberGenerator implements Radom{

    private static final int UPPER_BOUND = 10;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(UPPER_BOUND);
    }
}
