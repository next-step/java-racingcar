package error;

public enum CustomError {
    NEGATIVE_NUMBER_ERROR("Input number should be positive number"),
    NUMBER_FORMAT_ERROR("Input value is not number format");

    private final String errorContent;

    CustomError(String errorContent) {
        this.errorContent = errorContent;
    }

    public String getErrorContent() {
        return errorContent;
    }
}
