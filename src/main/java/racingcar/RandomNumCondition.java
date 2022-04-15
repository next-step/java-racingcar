package racingcar;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumCondition implements Condition {

    @Override
    public boolean isSatisfiedBy() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 9);

        if (randomNum >= 4) {
            return true;
        }
        return false;
    }
}
