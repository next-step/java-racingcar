package study.racingcar.error;

public class InvalidCarNameException extends RuntimeException {

  public InvalidCarNameException(String message) {
    super(message);
  }
}
