package strcalculator;

import java.util.Scanner;
import strcalculator.domain.Calculator;
import strcalculator.domain.StringProcessor;

public class Application {

    private static final String REPEAT="다시 입력해주세요.";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            StringProcessor stringProcessor = new StringProcessor(sc.nextLine());
//            stringProcessor.inputStringValue();
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
