package step3.number;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomNumber implements Number {

    private static final int RANDOM_BOUND = 10;

    @Override
    public int generatedNumber() {
        return ThreadLocalRandom.current()
                .nextInt(RANDOM_BOUND);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return isRandomNumber(obj);
    }

    private boolean isRandomNumber(Object object) {
        return object instanceof RandomNumber;
    }

}
