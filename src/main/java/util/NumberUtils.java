package util;

public class NumberUtils {
    private final static int POSITIVE_NUMBER_ONE = 1;

    public static boolean notPositive(int number) {
        return number < POSITIVE_NUMBER_ONE;
    }
}