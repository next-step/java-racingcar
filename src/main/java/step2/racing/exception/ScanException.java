package step2.racing.exception;

public class ScanException extends RuntimeException {

    public ScanException(String message) { super(message);}
    public ScanException(Throwable cause) { super(cause); }
    public ScanException(String message, Throwable cause) { super(message, cause); }
}
