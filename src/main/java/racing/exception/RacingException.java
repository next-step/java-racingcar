package racing.exception;

import racing.domain.ErrorMessage;

public class RacingException extends RuntimeException {
  public RacingException(ErrorMessage message){
    super(message.getMessage());
  }
}
