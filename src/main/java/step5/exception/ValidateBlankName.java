package step5.exception;

public class ValidateBlankName extends  IllegalArgumentException {
    private final static String VALIDATE_BLANK_NAME = "이름이 빈값일 수는 없습니다.";
    public ValidateBlankName() {
        super(VALIDATE_BLANK_NAME);
    }
}
