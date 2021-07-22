package step3;

import java.util.Random;

public class NumberGenerator {

    public static int createRandomNumbers() {
        return new Random().nextInt(10);
    }

}
