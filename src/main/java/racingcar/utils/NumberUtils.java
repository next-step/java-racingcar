package racingcar.utils;

import java.util.Collections;
import java.util.List;

public class NumberUtils {

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public static int getMax(List<Integer> values) {
        return Collections.max(values);
    }
}
