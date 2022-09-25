package racingcar;

public class NotPositiveNumberException extends RuntimeException {

    private static final String MESSAGE = "양수만 입력할 수 있습니다.";

    public NotPositiveNumberException() {
        super(MESSAGE);
    }
}
