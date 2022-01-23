package strcalculator;

import java.util.List;
import strcalculator.domain.Calculator;
import strcalculator.domain.StringProcessor;

public class Application {

    public static void main(String[] args) {
        StringProcessor play = new StringProcessor();
        while (true) {
            play.getInput();
            play.checkInput();
            try {
                String[] numbers = play.parseInputNumber();
                String[] operands = play.parseInputOperands();
                List<String> result = play.getResult();
                Calculator calculator = new Calculator(result);
                calculator.calculate(numbers,operands);
                break;
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("다시 입력해주세요.");
            }
        }
    }
}
