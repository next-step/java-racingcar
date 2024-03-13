package step4.common;

import java.util.Random;

public class RandomBounded {

    private static final int FORWARD_STANDARD = 4;

    private final int random;

    public RandomBounded() {
        random = new Random().nextInt(10);
    }

    public boolean moreThanForwardStandard() {
        return random >= FORWARD_STANDARD;
    }

}
