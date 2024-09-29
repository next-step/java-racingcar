package exception;

public class OutOfRangeException extends RuntimeException {
    public OutOfRangeException(int number) {
        super("Only accepts integers between 0 and 9: " + number);
    }
}
