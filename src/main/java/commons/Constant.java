package commons;

import java.util.regex.Pattern;

public class Constant {
    public static final String BASIC_SPLIT_REGEX = ",|:";
    public static final String NUMBER_RANGE_REGEX = "[0-9]";

    public static final String NEGATIVE_OR_NON_NUMERIC_ERR_MSG = "숫자 이외의 값 또는 음수가 입력되었습니다.";

    public static final Pattern CUSTOM_SPLIT_PATTERN = Pattern.compile("//(.)\n(.*)");
}
