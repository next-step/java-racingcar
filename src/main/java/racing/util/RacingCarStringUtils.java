package racing.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class RacingCarStringUtils {
    public static List<String> splitByComma(String rawString) {
        if (rawString == null) {
            throw new IllegalArgumentException("문자열로 빈값은 허용하지 않습니다.");
        }

        String[] splittedStr = rawString.split(",");
        return Arrays.stream(splittedStr)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String getHyphenStr(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("요청값은 0보다 커야 합니다.");
        }

        return new String(new char[length]).replace("\0", "-");
    }
}
