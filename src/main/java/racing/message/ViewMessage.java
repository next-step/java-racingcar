package racing.message;

public enum ViewMessage {

    START_MESSAGE_CAR_NUMBER("자동차 대수는 몇 대 인가요?"),
    START_MESSAGE_TRY_COUNT("시도할 회수는 몇 회 인가요?");

    String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
