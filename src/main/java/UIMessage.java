enum UIMessage {
    ASK_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_BETTING_COUNT("시도할 회수는 몇회인가요?"),

    NOTICE_RESULT_START("실행 결과"),
    NOTICE_CAR_RUN("-"),
    NOTICE_WINNER("가 최종 우승했습니다.");

    private String message;

    UIMessage(String message) {
        this.message = message;
    }

    public void println() {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }
}