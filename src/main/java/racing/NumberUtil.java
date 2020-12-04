package racing;

import java.util.Random;

public class NumberUtil {
    private static final Random random = new Random();

    public static int toInt(String strNumber) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(strNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("Missmatch integer type");
        }
        return parseInt;
    }

    public static int getRandomNumber() {
        int number = random.nextInt(10);
        return number;
    }
}
