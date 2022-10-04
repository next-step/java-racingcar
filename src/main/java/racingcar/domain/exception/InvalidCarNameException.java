package racingcar.domain.exception;

public class InvalidCarNameException extends RuntimeException {
    public InvalidCarNameException(int minCarNameLength, int maxCarNameLength) {
        super("The car name is at least " + minCarNameLength + " characters and up to " + maxCarNameLength + " characters.");
    }
}
