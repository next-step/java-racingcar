package racingcar.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureRandomPicker implements RandomPicker {

    private static final int RANDOM_BOUND = 10; // random number range => 0 ~ 9

    private static final SecureRandom secureRandom;

    static {
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
    @Override
    public GameNumber pickNumber() {
        return GameNumber.newNumber(secureRandom.nextInt(RANDOM_BOUND));
    }
}
