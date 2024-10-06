package racingcar.domain;

import java.util.Random;

public class SystemRandomHolder implements RandomHolder {
    public static final Random RANDOM = new Random();
    public static final int BOUND = 10;

    @Override
    public int getNumber() {
        return RANDOM.nextInt(BOUND);
    }
}
