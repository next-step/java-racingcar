package racingcar.exception;

public class GameNotPreparedException extends RuntimeException{

  public GameNotPreparedException() {
  }

  public GameNotPreparedException(String message) {
    super(message);
  }
}
