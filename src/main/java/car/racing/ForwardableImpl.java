package car.racing;

import java.util.Random;

public class ForwardableImpl implements Forwardable {

    private static final int LIMIT = 10;
    private static final int THRESHOLD = 4;

    private final Random random = new Random();

    @Override
    public boolean forwardable() {
        return random.nextInt(LIMIT) >= THRESHOLD;
    }
}
