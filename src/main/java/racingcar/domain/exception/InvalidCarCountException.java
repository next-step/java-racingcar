package racingcar.domain.exception;

public class InvalidCarCountException extends RuntimeException {
    public InvalidCarCountException() {
        super("Number of cars is greater than 0 and trial count must be greater than or equal to 1.");
    }
}
