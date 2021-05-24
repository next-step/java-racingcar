package calculator;

public class Exception {

    public void inputNullException() {
        throw new IllegalArgumentException("값을 입력해 주세요.");
    }

    public void wrongInputException() {
        throw new IllegalArgumentException("올바른 값을 입력해주세요.");
    }

    public void notFourRuleException() {
        throw new IllegalArgumentException("올바른 연산자를 입력해주세요.");
    }
}