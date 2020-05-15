package racinggame;

public class InputValueException extends RuntimeException {

    public InputValueException() {
        super("입력 값은 0 보다 커야 합니다.");
    }
}
