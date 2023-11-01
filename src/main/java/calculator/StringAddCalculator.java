package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        Input input = new Input(text);

        if (input.isEmptyOrNull()) {
            return 0;
        }

        if (input.isSingleDigit()) {
            return Util.strToInt(text);
        }

        Calculator calculator = new Calculator();
        return calculator.sum(text);
    }

}
