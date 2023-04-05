package step2;

import java.util.List;

public class StringCalculateExecutor {

    private static class CalculatorInstanceLazyHolder {

        private static final StringCalculateExecutor INSTANCE = new StringCalculateExecutor();
    }

    public static StringCalculateExecutor getInstance() {

        return CalculatorInstanceLazyHolder.INSTANCE;
    }

    public int execute(String input) {

        List<String> inputToInputList = StringCalculateSeparator.getInstance().executeSeparator(input);

        StringCalculateValidator.getInstance().executeValidator(inputToInputList);

        return StringCalculateCalculator.getInstance().executeCalculator(inputToInputList);
    }
}
