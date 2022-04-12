package step3.domain;

import java.util.Random;

public class RandomProceedPolicy implements ProceedPolicy {

    private static final int POLICY_RANDOM_NUMBER = 4;

    @Override
    public boolean canMoveForward(Car car) {
        Random random = new Random();
        int randomInt = random.nextInt(10);
        return randomInt >= POLICY_RANDOM_NUMBER;
    }
}
