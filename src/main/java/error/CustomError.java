package error;

public enum CustomError {
    NEGATIVE_NUMBER_ERROR("Input number should be positive number");

    private final String errorContent;

    CustomError(String errorContent) {
        this.errorContent = errorContent;
    }

    public String getErrorContent() {
        return errorContent;
    }
}
