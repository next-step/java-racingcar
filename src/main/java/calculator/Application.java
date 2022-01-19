package calculator;

import calculator.domain.Expression;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        while (true) {
            String[] splitUserInput;

            try {
                System.out.print("식을 입력해 주세요(그만하려면 q): ");
                splitUserInput = Expression.getUserInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            long result = Expression.evaluate(splitUserInput);
            System.out.println(result);
        }
    }
}

// 이상하네