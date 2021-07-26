package racingcar.util;

import java.util.Arrays;
import java.util.Random;

public class InputCarNameSplitUtils {
    private static final String COMMA = ",";

    private InputCarNameSplitUtils() {

    }

    public static String[] getSplitStringArray(String input) {
//        String[] carNames = input.split(COMMA);
//
//        Arrays.stream(carNames)
//                .filter( carName -> carName.length() > 5)
//                .map()
//                .thow
        return input.split(COMMA);
    }
}
