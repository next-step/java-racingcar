package common;

public class StringValidation {

    public static void isEmptyOrNull(String[] inputs, String exceptionMessage) {
        if (inputs.length == 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
        for (String input : inputs) {
            isEmptyOrNull(input, exceptionMessage);
        }
    }

    public static void isEmptyOrNull(String input, String exceptionMessage) {
        if ("".equals(input) || null == input) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void isLimitOver(String[] inputs, int limit, String exceptionMessage) {
        for (String input : inputs) {
            isLimitOver(input, limit, exceptionMessage);
        }
    }

    public static void isLimitOver(String input, int limit, String exceptionMessage) {
        if (input.length() > limit) {
            throw new IllegalArgumentException(exceptionMessage);
        }

    }
}
