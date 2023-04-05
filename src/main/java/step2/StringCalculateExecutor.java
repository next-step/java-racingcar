package step2;

import step2.model.Input;

public class StringCalculateExecutor {

    private static class CalculatorInstanceLazyHolder {

        private static final StringCalculateExecutor INSTANCE = new StringCalculateExecutor();
    }

    public static StringCalculateExecutor getInstance() {

        return CalculatorInstanceLazyHolder.INSTANCE;
    }

    private StringCalculateExecutor() {

    }

    public int execute(String inputString) {

        Input input = StringCalculateSeparator.getInstance().executeSeparator(inputString);

        StringCalculateValidateExecutor.getInstance().executeValidator(input);

        return StringCalculateCalculator.getInstance().executeCalculator(input);
    }
}
