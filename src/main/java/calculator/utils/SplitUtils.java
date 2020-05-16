package calculator.utils;

import org.apache.commons.lang3.StringUtils;

public class SplitUtils {

    public static String[] split(String target) {
        if (StringUtils.isBlank(target)) {
            throw new IllegalArgumentException("올바른 값이 아닙니다. [" + target + "]");
        }

        return target.split(" ");
    }
}
