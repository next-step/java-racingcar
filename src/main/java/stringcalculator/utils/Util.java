package stringcalculator.utils;

import java.util.Arrays;

public class Util {

    public static int sumString(String[] stringArray) {
        return Arrays.stream(stringArray)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
