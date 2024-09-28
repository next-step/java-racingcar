package calc;

public class StringAddCalculator {

    public int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        return StringAddCalculatorUtils.split(text);
    }
}
