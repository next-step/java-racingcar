package step4;

public class WinnerException extends Exception {

  public WinnerException() {
    this("아직 경기가 종료되지 않았습니다.");
  }

  public WinnerException(String message) {
    super(message);
  }

}
