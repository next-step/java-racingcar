package stringcalculator;

public class StringCalculatorMain {
    public static void main(String[] args) {
        StringCalculatorView view = new StringCalculatorView();
        StringCalculator stringCalculator = new StringCalculator();

        String input = view.inputString();
        stringCalculator.checkBlank(input);

        String[] splitString = stringCalculator.splitBySeparator(input);
        int result = stringCalculator.calculateSplitString(splitString);

        view.outputResult(result);
    }
}
