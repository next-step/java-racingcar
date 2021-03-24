package step5.exception;

public class IllegalNameLengthException extends RuntimeException {
  public IllegalNameLengthException(String message) {
    super(message);
  }
}
