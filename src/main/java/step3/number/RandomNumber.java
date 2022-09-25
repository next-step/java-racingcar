package step3.number;

import java.util.Random;

public final class RandomNumber implements Number {

    private static final Random RANDOM = new Random();

    @Override
    public int generatedNumber() {
        return RANDOM.ints(0, 10)
                .findFirst()
                .orElse(0);
    }

}
