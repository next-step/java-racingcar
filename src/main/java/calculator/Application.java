package calculator;

import calculator.domain.Calculator;
import calculator.domain.ExpressionParser;
import calculator.domain.Input;
import calculator.domain.Operators;
import calculator.domain.Terms;
import java.io.IOException;
import java.util.InputMismatchException;

public class Application {

    public static void main(String[] args) throws IOException {
        while (true) {
            String userInput;
            double result;

            try {
                System.out.print("식을 입력해 주세요(그만하려면 q): ");
                userInput = Input.getUserInput();

                ExpressionParser parser = new ExpressionParser(userInput);
                Operators operators = parser.getOperators();
                Terms terms = parser.getTerms();
                result = Calculator.evaluate(terms, operators);

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 해당 자리에는 값(숫자)이 위치해야 합니다.(v op v op v ..)");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (ArithmeticException e) {
                System.out.println("[ERROR] 0으로 나눌 수 없습니다.");
                continue;
            }

            System.out.println(result);
        }
    }
}