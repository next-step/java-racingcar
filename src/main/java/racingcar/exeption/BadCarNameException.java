package racingcar.exeption;

public class BadCarNameException extends RuntimeException {
    public BadCarNameException(String msg) {
        super(msg);
    }
}
