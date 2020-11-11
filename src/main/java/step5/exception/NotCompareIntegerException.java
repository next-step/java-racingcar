package step5.exception;

public class NotCompareIntegerException extends IllegalArgumentException{

    public static final String NOT_COMPARE_INTEGER = "해당 Integer는 비교를 할 수 없습니다.";

    public NotCompareIntegerException() {
        super(NOT_COMPARE_INTEGER);
    }
}
