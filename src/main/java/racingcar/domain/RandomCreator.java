package racingcar.domain;

import java.util.Random;

public class RandomCreator {

    public static int createNewPosition() {
        return new Random().nextInt(10);
    }
}
