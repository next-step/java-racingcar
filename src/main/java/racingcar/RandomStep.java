package racingcar;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomStep {

    public static int step() {
        return ThreadLocalRandom.current().nextInt(0, 9);
    }
}
