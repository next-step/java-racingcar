package common.util;

public class Preconditions {
    private Preconditions() {
        throw new AssertionError();
    }
    
    public static void checkArgument(final boolean expression, final Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void checkArgument(final boolean expression, final Message message) {
        checkArgument(expression, message.getMessage());
    }
}
