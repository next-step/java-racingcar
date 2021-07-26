package racingcar.util;

import java.util.Random;

public class InputCarNameSplitUtils {
    private static final String COMMA = ",";

    private InputCarNameSplitUtils() {

    }

    public static String[] getSplitStringArray(String nameOfCar) {
        return nameOfCar.split(COMMA);
    }
}
