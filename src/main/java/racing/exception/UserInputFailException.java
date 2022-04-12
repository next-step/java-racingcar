package racing.exception;

public class UserInputFailException extends RuntimeException {

  public UserInputFailException(String message, Throwable cause) {
    super(message, cause);
  }
}
