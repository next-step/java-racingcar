package racing.ui;

public enum Message {
  INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
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
