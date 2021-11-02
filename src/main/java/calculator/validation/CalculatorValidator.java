package calculator.validation;

public final class CalculatorValidator {
    private static final Long ZERO = 0L;
    public static final String EMPTY_ERROR_MESSAGE = "입력값이 null 또는 빈 공백 문자입니다.";
    public static final String DIVIDE_BY_ZERO_ERROR_MESSAGE = "0으로 나눌 수 없습니다.";
    public static final String DIVIDE_RESULT_ERROR_MESSAGE = "나눗셈의 결과는 정수로 떨어져야 합니다.";

    private CalculatorValidator() {
        throw new IllegalStateException("CalculatorValidator을 직접 생성할 수 없습니다.");
    }

    public static void checkInputEmpty(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    public static void validateDivide(Long operand1, Long operand2) {
        validateDivideByZero(operand2);
        validateOfDivideResult(operand1, operand2);
    }

    private static void validateDivideByZero(Long operand2) {
        if (ZERO.equals(operand2)) {
            throw new IllegalArgumentException(DIVIDE_BY_ZERO_ERROR_MESSAGE);
        }
    }

    private static void validateOfDivideResult(Long operand1, Long operand2) {
        if (operand1 % operand2 != 0) {
            throw new IllegalArgumentException(DIVIDE_RESULT_ERROR_MESSAGE);
        }
    }
}
