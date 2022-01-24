package stringcalculator.common;

public class ErrorMessage {

    private ErrorMessage() {
    }

    public static final String ERROR_MESSAGE_NULL = "[ERROR] 입력값은 NULL일 수 없습니다.";
    public static final String ERROR_MESSAGE_BLANK = "[ERROR] 입력값은 공백일 수 없습니다.";
    public static final String ERROR_MESSAGE_SIGN = "[ERROR] 입력값이 사칙 연산 기호가 아닙니다.";
    public static final String ERROR_MESSAGE_DIVIDED_BY_ZERO = "[ERROR] 0으로 나눌 수 없습니다.";

}