package step3.model;

public enum Message {
    ASK_CAR_CNT("자동차 대수는 몇 대 인가요?", "1대 이상 입력하셔야 게임이 가능합니다."),
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
