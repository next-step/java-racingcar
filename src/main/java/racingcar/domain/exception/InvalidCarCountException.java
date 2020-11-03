package racingcar.domain.exception;

public class InvalidCarCountException extends RuntimeException {
    public InvalidCarCountException() {
        super("invalid car count");
    }
}
