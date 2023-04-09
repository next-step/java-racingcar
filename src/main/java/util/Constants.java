package util;

import java.util.regex.Pattern;

public class Constants {
    public static final int ZERO = 0;
    public static final String DELIMITER_REGEX_BASIC = ",|:";
    public static final Pattern PATTERN_DELIMITER_CUSTOM = Pattern.compile("//(.)\n(.*)");
    public static final int IDX_CUSTOM_DELIMITER = 1;
    public static final int IDX_INPUT_STRING = 2;
    public static final String ERROR_MESSAGE_INPUT_NOT_INTEGER = "정수가 아닌 값은 입력할 수 없습니다.";
}
