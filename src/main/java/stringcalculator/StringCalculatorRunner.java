package stringcalculator;

public class StringCalculatorRunner {

    public static int run(String inputText) {
        StringCalculator stringCalculator = StringCalculatorFactory.create(inputText);

        return stringCalculator.sumString();
    }
}
