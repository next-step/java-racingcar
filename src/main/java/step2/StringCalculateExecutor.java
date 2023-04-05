package step2;

public class StringCalculateExecutor {

    private static class CalculatorInstanceLazyHolder {
        private static final StringCalculateExecutor INSTANCE = new StringCalculateExecutor();
    }

    public static CalculatorInstanceLazyHolder getInstance() {
        return StringCalculateExecutor.getInstance();
    }


}
