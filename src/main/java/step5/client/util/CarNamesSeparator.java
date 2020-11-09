package step5.client.util;

import java.util.Arrays;
import java.util.List;

public class CarNamesSeparator {
    private static final String SEPARATOR = ",";

    private CarNamesSeparator() {
        throw new AssertionError();
    }

    public static List<String> split(final String carNames) {
        return Arrays.asList(carNames.split(SEPARATOR));
    }
}
