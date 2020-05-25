package calculator;

import org.apache.commons.lang3.StringUtils;

public class SplitUtils {

    private static final String DEFAULT_DELIMITER = " ";

    public static String[] split(String target) {
        if (StringUtils.isBlank(target)) {
            throw new IllegalArgumentException("올바른 값이 아닙니다. [" + target + "]");
        }

        return target.split(DEFAULT_DELIMITER);
    }
}
