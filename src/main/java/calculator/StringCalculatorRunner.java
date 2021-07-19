package calculator;

class StringCalculatorRunner {
    public static void main(String[] args) {
        StringCalculatorPrinter.print(StringCalculator
                                              .create()
                                              .enter("2 + 3 * 4 / 2")
                                              .calculate()
                                     );
    }
}
