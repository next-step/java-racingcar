package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

    private StringUtil() {
    }

    public static List<String> split(String values, String Delimiter) {
        try {
            return Arrays.stream(values.split(Delimiter)).collect(Collectors.toList());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("잘못된 입력 값 입니다.");
        }
    }

}
