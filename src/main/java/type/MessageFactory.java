package type;

public class MessageFactory {
    private static final String INPUT_ERROR_MESSAGE = "입력값이 올바르지 않습니다.";

    MessageFactory() {
    }

    public static String getInputErrorMessage() {
        return INPUT_ERROR_MESSAGE;
    }
}
