package racewinner.expteion;

public class InvalidDelimiterException extends RuntimeException {
    private final static String INVALID_DELIMITER_MSG = "','구분자 외의 다른 구분자를 사용 할 수 없습니다.";
    public InvalidDelimiterException() {
        super(INVALID_DELIMITER_MSG);
    }
}
