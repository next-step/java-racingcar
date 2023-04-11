package racingcar.utils;

public class RandomNumberGenerator {

    public static int generateRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }
}
