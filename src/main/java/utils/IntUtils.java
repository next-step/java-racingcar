package utils;

import java.util.Random;
import java.util.regex.Pattern;

public class IntUtils {

    private static final Pattern pattern = Pattern.compile("-?\\d+");
    private static final Random random = new Random();

    private IntUtils() {}

    public static boolean isInt(String str) {
        return pattern.matcher(str).matches();
    }

    public static int getRandomUnder(int bound) {
        return random.nextInt(bound);
    }
}