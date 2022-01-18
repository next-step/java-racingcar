package calculator;

import calculator.domain.Expression;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        String[] splitUserInput = Expression.getUserInput();
        long result = Expression.evaluate(splitUserInput);

        System.out.println(result);
    }
}
