package calculator;

class StringCalculatorRunner {
    public static void main(String[] args) {
        StringCalculator stringCalculator = StringCalculator.create();

        stringCalculator.enter("2 + 3 * 4 / 2")
                .calculate();
    }
}
