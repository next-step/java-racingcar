package utils;

import java.security.SecureRandom;

public class RandomNumber {
    public static final int BOUND = 10;

    public static int generateNumber() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(BOUND);
    }
}
