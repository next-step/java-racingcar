package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        Input input = new Input(text);

        if (input.isEmptyOrNull()) {
            return 0;
        }

        if (input.isSingleDigit()) {
            return Integer.parseInt(text);
        }

        return 0;
    }

}
