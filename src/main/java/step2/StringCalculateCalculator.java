package step2;

import java.util.List;

public class StringCalculateCalculator {

    private static class CalculatorInstanceLazyHolder {

        private static final StringCalculateCalculator INSTANCE = new StringCalculateCalculator();
    }

    public static StringCalculateCalculator getInstance() {

        return CalculatorInstanceLazyHolder.INSTANCE;
    }

    private StringCalculateCalculator(){

    }

    public int executeCalculator(List<String> inputList) {

        if (inputList.size() == 0) {
            return 0;
        }

        return inputList.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
