package calculator;

import calculator.domain.Expression;
import calculator.ui.View;

public class Application {

    public static void main(String[] args) {
        String userInput = View.getUserInput();
        long result = Expression.execute(userInput);
        View.printResult(result);
    }

}
