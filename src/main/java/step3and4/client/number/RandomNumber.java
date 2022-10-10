package step3and4.client.number;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomNumber implements Number {

    private static final int RANDOM_BOUND = 10;

    @Override
    public int generatedNumber() {
        return ThreadLocalRandom.current()
                .nextInt(RANDOM_BOUND);
    }

}
