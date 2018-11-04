package racing.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class StringUtils {
    public static List<String> splitByComma(String rawString) {
        if (rawString == null) {
            throw new IllegalArgumentException("문자열로 빈값은 허용하지 않습니다.");
        }

        String[] splittedStr = rawString.split(",");
        return Arrays.stream(splittedStr)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
