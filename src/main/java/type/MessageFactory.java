package type;

public class MessageFactory {
    private static final String INPUT_BAD_REQUEST_MESSAGE = "입력값이 올바르지 않습니다.";
    private static final String INPUT_DUPLICATED_MESSAGE = "중복 입력입니다.";
    private static final String NEW_LINE = "\n";

    MessageFactory() {
    }

    public static String badInputMessage() {
        return INPUT_BAD_REQUEST_MESSAGE;
    }

    public static String duplicatedInputMessage() {
        return INPUT_DUPLICATED_MESSAGE;
    }

    public static String newLine() {
        return NEW_LINE;
    }
}
