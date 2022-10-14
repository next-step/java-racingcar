package refactoringracingcar.racingexception;

public class InputValueException extends RuntimeException {

    public InputValueException() {

    }

    public InputValueException(String message) {
        super(message);
    }
}
