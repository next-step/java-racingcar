package calculator;

public class Exception {
    public static final String INPUT_NULL = "값을 입력해 주세요.";
    public static final String WRONG_INPUT = "올바른 값을 입력해주세요.";
    public static final String NOT_FOUR_RULE = "올바른 연산자를 입력해주세요.";

    public void inputNullException() {
        throw new IllegalArgumentException(INPUT_NULL);
    }

    public void wrongInputException() {
        throw new IllegalArgumentException(WRONG_INPUT);
    }

    public void notFourRuleException() {
        throw new IllegalArgumentException(NOT_FOUR_RULE);
    }
}