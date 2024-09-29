package racinggame.exception;

public enum ErrorMessage {

    INVALID_CAR_NAME("자동차이름은 최소 %d자 이상 최대 %d자 이하여야 합니다."),
    CAR_COUNT_REQUIREMENT_ERROR("최소 %d대 이상이 필요합니다."),
    ROUND_REQUIREMENT_ERROR("최소 %d라운드 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessage(Object... args) {
        return String.format(this.message, args);
    }

}
