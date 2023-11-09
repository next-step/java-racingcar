package error;

public enum CustomError {
    NEGATIVE_NUMBER_ERROR("Input number should be positive number"),
    EXCEED_MAX_LENGTH_ERROR("입력한 문자열의 길이를 확인해주세요");

    private final String errorContent;

    CustomError(String errorContent) {
        this.errorContent = errorContent;
    }

    public String getErrorContent() {
        return errorContent;
    }
}
