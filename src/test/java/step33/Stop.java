package step33;

import java.util.Random;

public class Stop extends RandomGenerator{

    public Stop(Random random) {
        super(random);
    }

    @Override
    public int getRandomNumber() {
        return 3;
    }
}
