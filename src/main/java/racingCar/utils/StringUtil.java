package racingCar.utils;

public class StringUtil {
    private static final String SEPARATOR = ",";

    private StringUtil() {
    }

    public static String[] divideByComma(String inputName) {
        return inputName.split(SEPARATOR);
    }
}
