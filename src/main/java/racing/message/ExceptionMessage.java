package racing.message;

public enum ExceptionMessage {

    NOT_EXIST_CAR_NAME("자동차 이름이 존재하지 않습니다."),
    CANNOT_EXCEED_5_CHARACTERS("자동차 이름은 5자를 초과할 수 없습니다.");

    String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
