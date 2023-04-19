package racingCar.exception;

public class NotAllowedGameSettingException extends RuntimeException {

  public NotAllowedGameSettingException(String message) {
    super("허용되지 않은 레이싱카 게임 세팅: " + message);
  }
}
