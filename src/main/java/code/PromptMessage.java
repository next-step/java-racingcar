package code;

public enum PromptMessage {
    CAR_NAME_IS_EQUAL_LOWER_THAN_5("자동차 이름은 5자 이내여야 합니다."),
    INPUT_HAVE_TO_BE_NOT_BLANK("입력 값은 빈 값이 안됩니다. 다시 입력 해주세요.");

    private String message;

    PromptMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
