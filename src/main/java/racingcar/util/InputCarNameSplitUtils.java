package racingcar.util;

import racingcar.exception.InvalidCarNameException;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class InputCarNameSplitUtils {
    private static final String COMMA = ",";

    private InputCarNameSplitUtils() {

    }

    public static String[] getSplitStringArray(String input) {
        String[] carNames = input.split(COMMA);

        Arrays.stream(carNames)
                .filter( carName -> carName.length() > 5)
                .findAny()
                .ifPresent(carName -> {
                    throw new InvalidCarNameException(carName);
                } );
        return input.split(COMMA);
    }
}
