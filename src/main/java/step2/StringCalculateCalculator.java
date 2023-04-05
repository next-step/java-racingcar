package step2;

import java.util.List;

public class StringCalculateCalculator {

    private static class CalculatorInstanceLazyHolder {
        private static final StringCalculateCalculator INSTANCE = new StringCalculateCalculator();
    }

    public static CalculatorInstanceLazyHolder getInstance() {
        return StringCalculateCalculator.getInstance();
    }

    public int executeCalculator(List<String> inputList) {

        return inputList.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
