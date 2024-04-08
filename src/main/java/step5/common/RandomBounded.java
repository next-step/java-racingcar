package step5.common;

import java.util.Random;

import static step5.common.Constant.FORWARD_STANDARD;

public class RandomBounded {

    private final int random;

    public RandomBounded() {
        random = new Random().nextInt(10);
    }

    public boolean moreThanForwardStandard() {
        return random >= FORWARD_STANDARD;
    }

}
