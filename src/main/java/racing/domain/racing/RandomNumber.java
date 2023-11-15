package racing.domain.racing;

import java.util.Random;

public class RandomNumber {

    private static final Random random = new Random();

    public static int randomNumberUnder10() {
        return random.nextInt(10);
    }
}
