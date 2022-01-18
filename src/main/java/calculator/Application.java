package calculator;

import calculator.domain.Expression;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        String[] splitUserInput = Expression.getUserInput();
        Expression.evaluate(splitUserInput);

        //TODO Expression.evaluate, 반복문과 interpreter
        // Expression.interpreter(val1, val2, op) switch?

    }
}
