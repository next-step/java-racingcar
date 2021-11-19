package step4.dto.count;

import step4.common.Number;

import java.util.Random;

public class RandomNumber {
    private static final Random RANDOM = new Random();

    public static Count newRandom() {
        Count count = new Count(RANDOM.nextInt(Number.TEN.getValue()));

        return count;
    }
}
