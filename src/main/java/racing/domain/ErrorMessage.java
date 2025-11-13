package racing.domain;

public enum ErrorMessage {
  NAME_VALIDATION_EMPTY("이름은 비어있을 수 없습니다."),
  NAME_VALIDATION_LENGTH("이름은 5자 이하여야 합니다.");

  private String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
