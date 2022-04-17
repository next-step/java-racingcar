package racingcar;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumCondition implements Condition {

    @Override
    public boolean isSatisfied() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 9);
        return randomNum >= 4;
    }
}
