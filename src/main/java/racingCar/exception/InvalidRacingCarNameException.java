package racingCar.exception;

public class InvalidRacingCarNameException extends RuntimeException {
  public InvalidRacingCarNameException(String message) {
    super("허용되지 않는 자동자 이름 탐지 : " + message);
  }
}
