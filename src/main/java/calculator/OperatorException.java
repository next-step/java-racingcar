package calculator;

public class OperatorException extends RuntimeException {
    private final String CUSTOM_OPERATOR_EXCEPTION_MESSAGE = "계산 중 오류가 발생하였습니다. : %s";
    private String message;

    public OperatorException(String errorMessage) {
        message = String.format(CUSTOM_OPERATOR_EXCEPTION_MESSAGE, errorMessage);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
