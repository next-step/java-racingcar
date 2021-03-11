package study.step4;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtils {

    private StringUtils() {
    }

    public static String convertIntegerToStringDash(int carlocation) {
        return Arrays.stream(new int[carlocation])
                .mapToObj(i -> RacingConstant.DASH)
                .collect(Collectors.joining(RacingConstant.DELIMITER));
    }
}
