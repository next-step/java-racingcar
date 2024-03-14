package step3.Common;

public class ErrorMessageConstants {
    public static final String CONSTRUCTOR_ERROR_MESSAGE = "유틸리티 클래스로 인스턴스 생성 불필요";

    private ErrorMessageConstants() {
        throw new AssertionError(ErrorMessageConstants.CONSTRUCTOR_ERROR_MESSAGE);
    }
}
