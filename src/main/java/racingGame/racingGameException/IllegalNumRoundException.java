package racingGame.racingGameException;

public class IllegalNumRoundException extends IllegalArgumentException {

  public IllegalNumRoundException() {
    super("올바르지 않은 라운드 숫자입니다.");
  }
}
