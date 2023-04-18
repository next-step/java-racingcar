package study.step5.exception;

public enum CustomException {
    NAME_MAX_LENGTH(5,  "이름이 다섯자 이상입니다.");
    private final int length;
    private final String message;

    CustomException(int length, String message) {
        this.length = length;
        this.message = message;
    }

    public int getLength() {
        return length;
    }

    public String getMessage() {
        return message;
    }
}
