package error;

public enum CustomError {
    NEGATIVE_NUMBER_ERROR("Input number should be positive number"),
    NOT_EXIST_SYMBOL_ERROR("사칙연산 기호를 확인해주세요"),
    EMPTY_INPUT_ERROR("값을 입력해주세요");

    private final String errorContent;

    CustomError(String errorContent) {
        this.errorContent = errorContent;
    }

    public String getErrorContent() {
        return errorContent;
    }
}
