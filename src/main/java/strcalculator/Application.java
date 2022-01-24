package strcalculator;

import strcalculator.domain.Calculator;
import strcalculator.domain.StringProcessor;

public class Application {

    public static void main(String[] args) {
        StringProcessor play = new StringProcessor();
        while (true) {
            play.getInput();
            play.checkInput();
            try {

                play.deleteSpaceString();
                String[] numbers = play.parseInputNumber();
                String[] operands = play.parseInputOperands();
                Calculator calculator = new Calculator(numbers, operands);
                calculator.calculate();
                break;
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("다시 입력해주세요.");
            }
        }
    }
}
