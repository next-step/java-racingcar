package step2.common.exception;

public enum CommonExceptionMessage {

    EXIST_NEGATIVE_NUMBER("음수는 입력하실 수 없어요, 입력값을 확인해주세요."),
    EXIST_NON_NUMERIC("숫자이외의 값은 입력할 수 없어요, 압력값을 확인해주세요");

    private final String userGuideMessage;

    CommonExceptionMessage(String userGuideMessage) {
        this.userGuideMessage = userGuideMessage;
    }

    public String getUserGuideMessage() {
        return userGuideMessage;
    }
}
