package racing.ui;

public enum Message {
  INPUT_CAR_COUNT("자동차 대수는 몇 대 인가요?"),
  INPUT_TRY_COUNT("시도할 회수는 몇 회 인가요?"),
  RESULT_MESSAGE("실행 결과");
  private String message;

  Message(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
