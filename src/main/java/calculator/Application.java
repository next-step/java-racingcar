package calculator;

import calculator.domain.Calculator;
import calculator.domain.ExpressionParser;
import calculator.domain.Input;
import calculator.domain.Operators;
import calculator.domain.Terms;
import java.io.IOException;

public class Application {


    public static void main(String[] args) throws IOException {
        while (true) {
            double result;

            String userInput = Input.getUserInput();

            ExpressionParser parser = new ExpressionParser(userInput);
            Operators operators = parser.getOperators();
            Terms terms = parser.getTerms();

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