package study.racing;

public enum RacingMessage {
      CAR_COUNT("자동차 대수는 몇 대 인가요?")
    , TRY_COUNT("시도할 회수는 몇 회 인가요?")
    , TRY_AGAIN("다시 입력해주세요.");

    private final String msg;

    RacingMessage(String msg) {
        this.msg = msg;
    }

    public String msg() {
        return msg;
    }

}
