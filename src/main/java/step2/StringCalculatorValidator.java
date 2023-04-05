package step2;

public class StringCalculatorValidator {

    private static class ValidatorInstanceLazyHolder {
        private static final StringCalculatorValidator INSTANCE = new StringCalculatorValidator();
    }

    public static StringCalculatorValidator getInstance() {
        return ValidatorInstanceLazyHolder.INSTANCE;
    }

    public void validate() {

    }
}
