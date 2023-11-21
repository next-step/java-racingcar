package racingCar.util.converter;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private Converter() {
    }

    public static List<String> splitToList(String separator, String value) {
        return Arrays.asList(value.split(separator));
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }
}
