package step2;

public enum ErrorMessage {
    NEGATIVE_NOT_SUPPORTED("음수는 지원하지 않습니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

}
