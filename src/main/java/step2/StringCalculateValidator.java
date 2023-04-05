package step2;

public class StringCalculateValidator {

    private static class ValidatorInstanceLazyHolder {
        private static final StringCalculateValidator INSTANCE = new StringCalculateValidator();
    }

    public static StringCalculateValidator getInstance() {
        return ValidatorInstanceLazyHolder.INSTANCE;
    }

    public void validate() {

    }
}
