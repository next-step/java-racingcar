package step3and4and5.client.number;

import step3and4and5.game.car.Number;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomNumber implements Number {

    private static final int RANDOM_BOUND = 10;

    @Override
    public int generatedNumber() {
        return ThreadLocalRandom.current()
                .nextInt(RANDOM_BOUND);
    }

}
