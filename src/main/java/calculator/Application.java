package calculator;

import calculator.domain.Parser;
import java.util.List;
import calculator.domain.Calculator;
import calculator.domain.Input;


public class Application {
    public static void main(String[] args) {
        System.out.println("연산 가능한 수식을 입력해주세요. (숫자, 연산자, 공백 문자만 허용됩니다.)");
        while (true) {
            try {
                String userInput = Input.getInput();
                List<String> parsedInput = Parser.parseInput(userInput);
                Calculator calculator = new Calculator();
                calculator.calculate(parsedInput);
                break;
            } catch(IllegalArgumentException | ArithmeticException e) {
                System.out.println("[ERROR] 연산 가능한 수식을 입력해주세요. (숫자, 연산자, 공백 문자만 허용됩니다.)");
            }
        }
    }
}
