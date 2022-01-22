package calculator;

import calculator.domain.Calculator;
import calculator.domain.ExpressionParser;
import calculator.domain.Input;
import calculator.domain.Operators;
import calculator.domain.Terms;
import java.io.IOException;

public class Application {

    private static final Object EXCEPTION_THROWN = null;

    public static void main(String[] args) throws IOException {
        while (true) {
            double result;

            System.out.print("식을 입력해 주세요(그만하려면 q): ");
            String userInput = Input.getUserInput();
            if (userInput == EXCEPTION_THROWN) {
                continue;
            }

            ExpressionParser parser = new ExpressionParser(userInput);
            Operators operators = parser.getOperators();
            Terms terms = parser.getTerms();
            if (operators == EXCEPTION_THROWN || terms == EXCEPTION_THROWN) {
                continue;
            }

            try {
                result = Calculator.evaluate(terms, operators);
            } catch (ArithmeticException e) {
                System.out.println("[ERROR] 0으로 나눌 수 없습니다.");
                continue;
            }

            System.out.println(result);
        }
    }
}