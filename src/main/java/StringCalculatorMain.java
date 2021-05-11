public class StringCalculatorMain {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        String input = stringCalculator.inputString();
        stringCalculator.calculate(input);
    }
}
