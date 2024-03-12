package step3;

import java.util.Random;

public class RandomPolicy implements Policy {

    private final Random random = new Random();
    private boolean attemptsSuccess;

    public boolean isAttemptsSuccess() {
        return attemptsSuccess;
    }

    @Override
    public int apply(int position) {
        if (isSuccess()) {
            return position += 1;
        }
        return position;
    }

    private boolean isSuccess() {
        attemptsSuccess = random.nextInt(10) >= 4;
        return attemptsSuccess;
    }
}
