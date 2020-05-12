package calculator.exception;

public class ErrorMessage {

    public static final String IS_NULL_OR_EMPTY = "입력 값이 null 이거나 빈 공백 문자입니다.";
    public static final String NOT_SUPPORTED_OPERATOR = "지원하지 않는 연산자입니다.";
    public static final String NOT_SUPPORTED_ARITHMETIC = "%s (사칙연산이 아님) 는" + NOT_SUPPORTED_OPERATOR;
    public static final String NOT_SUPPORTED_FORMAT = "형식에 맞지 않는 문자열입니다.";

    private ErrorMessage() {}
}
