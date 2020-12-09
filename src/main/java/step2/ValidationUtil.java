package step2;

public class ValidationUtil {

    public static void checkValidation(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text is null");
        }
        String[] splitText = text.split(" ");
        if (splitText.length == 1) {
            throw new IllegalArgumentException("text is not expression");
        }
        if (splitText.length % 2 != 1) {
            throw new IllegalArgumentException("text is not a valid expression");
        }
    }
}
