package step2;

public class UserInputValidation {

    public static boolean isStringEmpty(String testingValue) {
        try {
            if (testingValue.isBlank()) {
                throw new IllegalArgumentException("문자열이 공백 혹은 비어있습니다.");
            }

            return false;
        } catch (IllegalArgumentException exception) {

            return true;
        }
    }
}
