package calculator;

public class ExceptionMessage {

    private ExceptionMessage() {}

    public static final String INVALID_INPUT_STRING = "입력값은 필수입니다.";
    public static final String INVALID_OPERATION_SYMBOL = "입력한 값이 사칙연산 기호에 해당되지 않습니다.";
    public static final String INVALID_FORMAT_INPUT_NUMBER = "은 숫자가 아닙니다. 적절한 숫자를 입력해주세요.";
    public static final String INVALID_EMPTY_INPUT_NUMBER = "빈 문자열은 숫자가 아닙니다. 적절한 숫자를 입력해주세요.";
    public static final String DIVISION_BY_ZERO = "/ by zero .. 0으로 나눌 수 없습니다.";
}
