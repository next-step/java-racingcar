package step33;

import java.util.Random;

public class Go extends RandomGenerator {

    public Go(Random random) {
        super(random);
    }

    @Override
    public int getRandomNumber() {
        return 5;
    }
}
