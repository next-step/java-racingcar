package utils;

import java.security.SecureRandom;

public class RandomNumber {
    public static int generateNumber() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(10);
    }
}
