package stringcalculator.domain;

import java.util.regex.Pattern;

public class Constant {
    public static final int ZERO = 0;
    public static final String BLANK = " ";
    public static final String NULL_STRING = "";

    public static final Pattern INTEGER_PATTERN = Pattern.compile("^\\d+$");
    public static final Pattern OPERATOR_PATTERN = Pattern.compile("^(\\+)|(-)|(\\*)|(/)$");
    public static final Pattern LITERAL_PATTERN = Pattern.compile("^(\\D)$");

    public static final String NOT_NULL = "입력 값은 null 이거나 빈 공백 문자일 수 없습니다.";
    public static final String MUST_START_NUMBER = "입력값은 반드시 숫자로 시작해야 한다";
    public static final String MUST_USE_NUMBER_OPERATOR = "연산자는 사칙연산 기호만 사용할 수 있습니다.";
}
