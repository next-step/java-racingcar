package racingGame.racingGameException;

public class IllegalCarNameLengthException extends IllegalArgumentException {

  public IllegalCarNameLengthException() {
    super("자동차 이름이 너무 깁니다.");
  }
}
