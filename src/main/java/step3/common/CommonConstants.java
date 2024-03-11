package step3.common;

public class CommonConstants {
    public static final String CONSTRUCTOR_ERROR_MESSAGE = "유틸리티 클래스로 인스턴스 생성 불필요";

    private CommonConstants() {
        throw new AssertionError(CommonConstants.CONSTRUCTOR_ERROR_MESSAGE);
    }
}
