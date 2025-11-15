package racing.exception;

public class RacingException extends RuntimeException {

  public RacingException(ErrorMessage message) {
    super(message.getMessage());
  }
}
