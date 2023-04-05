package study.constant;

public abstract class StringCalcConstant {

    public static final String DEFAULT_DELIMITER_REGEX = "[,:;\\n]+";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "음수는 입력할 수 없습니다. (음수 숫자: %s)";
}