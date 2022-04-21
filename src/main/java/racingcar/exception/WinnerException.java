package racingcar.exception;

public class WinnerException extends RuntimeException {
    public WinnerException() {
        super("우승자 선별 중 오류가 발생하였습니다");
    }

    public WinnerException(String message) {
        super(message);
    }
}
