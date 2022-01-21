package calculator;

import calculator.domain.Calculator;
import calculator.domain.Expression;
import calculator.domain.ExpressionParser;
import calculator.domain.Input;
import java.io.IOException;
import java.util.InputMismatchException;

public class Application {

    public static void main(String[] args) throws IOException {
        while (true) {
            String[] splitUserInput;
            long result;

            try {
                System.out.print("식을 입력해 주세요(그만하려면 q): ");
                splitUserInput = Input.getUserInput();

                ExpressionParser parser = new ExpressionParser();
                Expression expression = parser.parseExpression(splitUserInput);

                result = Calculator.evaluate(expression);

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