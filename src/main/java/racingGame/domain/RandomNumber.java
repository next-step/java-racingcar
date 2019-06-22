package racingGame.domain;

import java.util.Random;

public class RandomNumber implements Number {

    private final int BASE_BOUND = 10;

    public int acceleratorNumber() {
        return new Random().nextInt(BASE_BOUND);
    }
}
