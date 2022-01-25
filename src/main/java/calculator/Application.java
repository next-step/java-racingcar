package calculator;

import calculator.domain.Calculator;
import calculator.domain.Expression;
import calculator.domain.Input;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        while (true) {
            String[] splitUserInput;

            try {
                System.out.print("식을 입력해 주세요(그만하려면 q): ");
                splitUserInput = Input.getUserInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            Expression expression = new Expression(splitUserInput);
            Calculator calculator = new Calculator(expression);
            long result = calculator.evaluate();
            System.out.println(result);
        }
    }
}