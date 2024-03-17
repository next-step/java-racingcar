package step3.common;

public enum ErrorMessageConstants {
    CONSTRUCTOR_ERROR_MESSAGE("유틸리티 클래스로 인스턴스 생성 불필요");
    private final String message;

    ErrorMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
