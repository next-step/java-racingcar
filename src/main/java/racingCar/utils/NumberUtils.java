package racingCar.utils;

public class NumberUtils {
    private NumberUtils() {
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}

