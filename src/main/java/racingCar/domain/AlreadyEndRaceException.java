package racingCar.domain;

public class AlreadyEndRaceException extends RuntimeException {

  public AlreadyEndRaceException(String msg) {
    super(msg);
  }
}
