package utils.validator;

public class Validator {

    public static boolean validateUserInput(String text) {
        if (isNull(text) || isEmpty(text)) {
            return false;
        }
        return true;
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isNull(String text) {
        return text == null;
    }
}
