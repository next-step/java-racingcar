package racingcar.domain.exception;

public class InvalidCarNameLengthException extends RuntimeException {
    public InvalidCarNameLengthException() {
        super("invalid car name length");
    }
}
