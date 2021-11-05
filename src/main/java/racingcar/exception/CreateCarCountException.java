package racingcar.exception;

public class CreateCarCountException extends RuntimeException {
    private static final String MESSAGE = "개수(%d)를 잘못 입력 했습니다.";

    public CreateCarCountException(int count) {
        super(String.format(MESSAGE, count));
    }
}
