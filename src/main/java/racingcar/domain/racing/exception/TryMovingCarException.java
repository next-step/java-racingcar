package racingcar.domain.racing.exception;

public class TryMovingCarException extends Exception {

  public TryMovingCarException() {
    super("남은 이동횟수가 없습니다.");
  }
}
