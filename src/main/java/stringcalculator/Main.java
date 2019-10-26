package stringcalculator;

import stringcalculator.parser.StringParser;
import stringcalculator.store.CalculatorBuffer;
import stringcalculator.view.InputView;

public class Main {

    private static InputView inputView = new InputView(System.in);

    public static void main(String[] args) {
        String input = inputView.input();

        String[] parsedInputs = StringParser.parse(input);

        CalculatorBuffer calculatorBuffer = new CalculatorBuffer(parsedInputs);

        Double result = StringCalculator.calculate(calculatorBuffer);

        System.out.println(result);
    }
}
