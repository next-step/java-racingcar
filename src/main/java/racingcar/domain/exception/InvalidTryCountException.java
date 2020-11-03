package racingcar.domain.exception;

public class InvalidTryCountException extends RuntimeException {
    public InvalidTryCountException() {
        super("invalid try count");
    }
}
