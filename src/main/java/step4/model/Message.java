package step4.model;

public enum Message {
    ASK_CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)", "이름은 비었습니다. 다시 입력해주세요."),
    ASK_TRY_CNT("시도할 회수는 몇 회 인가요?", "1회 이상 입력하셔야 게임이 가능합니다.");

    private String inputMessage;
    private String errorMessage;

    Message(String inputMessage, String errorMessage) {
        this.inputMessage = inputMessage;
        this.errorMessage = errorMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
