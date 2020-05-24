package step5.Exception;

public class WinnerException extends RuntimeException {

  public WinnerException() {
    this("아직 경기가 종료되지 않았습니다.");
  }

  public WinnerException(String message) {
    super(message);
  }

}
