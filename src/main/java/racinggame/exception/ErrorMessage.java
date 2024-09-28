package racinggame.exception;

public enum ErrorMessage {
    CAR_COUNT_REQUIREMENT_ERROR("최소 %s대 이상이 필요합니다."),
    ROUND_REQUIREMENT_ERROR("최소 %s라운드 이상이어야 합니다.");

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
