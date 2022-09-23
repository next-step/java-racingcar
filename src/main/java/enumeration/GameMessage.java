package enumeration;

public enum GameMessage {

    CAR_NUMBER_ASK_QUESTION("자동차 대수는 몇 대 인가요?"),
    TRY_NUMBER_ASK_QUESTION("시도할 회수는 몇 회 인가요?"),
    RUN_RESULT_MSG("실행 결과"),
    RUN_FAIL_MSG("자동차 대수 , 시도할 회수는 숫자값이여만 합니다.")
    ;

    private final String msg;
    GameMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}