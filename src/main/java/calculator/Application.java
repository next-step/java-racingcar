package calculator;

import calculator.domain.Expression;
import calculator.domain.Input;
import java.io.IOException;
import java.util.InputMismatchException;

public class Application {

    public static void main(String[] args) throws IOException {
        while (true) {
            String[] splitUserInput;

            try {
                System.out.print("식을 입력해 주세요(그만하려면 q): ");
                splitUserInput = Input.getUserInput();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 해당 자리에는 값(숫자)이 위치해야 합니다.(v op v op v ..)");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }

            Expression expression = new Expression(splitUserInput);
            long result = expression.evaluate();
            System.out.println(result);
        }
    }
}