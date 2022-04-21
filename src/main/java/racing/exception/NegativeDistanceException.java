package racing.exception;

public class NegativeDistanceException extends RuntimeException {

  private static final String ERROR_MESSAGE = "거리는 음수로 생성될 수 없습니다.";

  public NegativeDistanceException() {
    super(ERROR_MESSAGE);
  }
}
