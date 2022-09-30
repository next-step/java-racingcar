package step3.util;

public class ConvertUtil {

    public static StringBuilder convertNumToDash(int steps) {
        StringBuilder value = new StringBuilder();

        value.append("-".repeat(Math.max(0, steps)));
        return value;
    }

}
