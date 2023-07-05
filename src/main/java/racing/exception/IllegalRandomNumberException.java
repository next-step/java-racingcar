package racing.exception;

public class IllegalRandomNumberException extends RacingBaseException {
    private static final String MESSAGE = "랜덤으로 생성된 값이 잘못되었습니다. 값은 0이상 9이하의 정수여야 합니다.";

    public IllegalRandomNumberException() {
        super(MESSAGE);
    }
}
