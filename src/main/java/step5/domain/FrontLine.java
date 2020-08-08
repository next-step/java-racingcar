package step5.domain;

import org.apache.commons.lang3.StringUtils;

public class FrontLine {
    public static String validNames(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("공백이 들어갈 수 없습니다.");
        }
        return input;
    }
}
