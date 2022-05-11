package racingcar.exception;

public class RaceException extends RuntimeException {
    public RaceException() {
        super("Race 처리 중 오류가 발생하였습니다");
    }

    public RaceException(String message) {
        super(message);
    }
}
