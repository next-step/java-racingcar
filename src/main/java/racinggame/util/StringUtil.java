package racinggame.util;

import racinggame.exception.ImpossibleConstructionException;

import java.util.Arrays;
import java.util.List;

public final class StringUtil {

    private StringUtil() {
        throw new ImpossibleConstructionException(getClass().getName());
    }

    public static List<String> splitString(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }
}
