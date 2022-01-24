package strcalculator;

import strcalculator.domain.Calculator;
import strcalculator.domain.StringProcessor;

public class Application {

    private static final String REPEAT="다시 입력해주세요.";
    public static void main(String[] args) {
        StringProcessor stringProcessor = new StringProcessor();
        while (true) {
            stringProcessor.inputStringValue();
            stringProcessor.checkInput();
            try {
                stringProcessor.deleteSpaceString();
                String[] numbers = stringProcessor.parseInputNumber();
                String[] operands = stringProcessor.parseInputOperands();
                Calculator calculator = new Calculator(numbers, operands);
                calculator.calculate();
                break;
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(REPEAT);
            }
        }
    }

}
