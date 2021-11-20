package step4.dto.count;

import step4.common.MyNumber;

import java.util.Random;

public class RandomNumber {
    private static final Random RANDOM = new Random();

    public static Count newRandom() {
        return new Count(RANDOM.nextInt(MyNumber.TEN.getValue()));
    }
}
