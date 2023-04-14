package study.racingcar.error;

public class InvalidNameException extends RuntimeException {

  public InvalidNameException(String message) {
    super(message);
  }
}
