package exception;

public class InvalidPositionException extends CustomException {
    private static final String ERROR_MSG = "자동차 위치는 음수가 될 수 없습니다.";
    public InvalidPositionException() {
        super(ERROR_MSG);
    }
}
