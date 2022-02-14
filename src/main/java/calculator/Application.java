package calculator;

import calculator.domain.Parser;
import calculator.view.ResultView;
import java.util.List;
import calculator.domain.Calculator;
import calculator.view.InputView;


public class Application {
    public static void main(String[] args) {
        System.out.println("연산 가능한 수식을 입력해주세요. (숫자, 연산자, 공백 문자만 허용됩니다.)");
        while (true) {
            try {
                String userInput = InputView.getInput();
                List<String> parsedInput = Parser.parseInput(userInput);
                Calculator calculator = Calculator.getInstance();
                int result = calculator.calculate(parsedInput);
                ResultView.printResult(result);
                break;
            } catch(IllegalArgumentException | ArithmeticException | NullPointerException e) {
                System.out.println("[ERROR] 연산 가능한 수식을 입력해주세요. (숫자, 연산자, 공백 문자만 허용됩니다.)");
            }
        }
    }
}
