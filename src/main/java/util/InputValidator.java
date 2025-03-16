package util;

import exception.NegativeNumberException;

public class InputValidator {
    public static int checkValidCarCount(int carCount) {
        if (carCount <= 0) {
            throw new NegativeNumberException("invalid car count : " + carCount);
        }
        return carCount;
    }

    public static int checkValidTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new NegativeNumberException("invalid try count : " + tryCount);
        }
        return tryCount;
    }
}
