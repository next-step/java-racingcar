package calculator;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        User user = new User();
        final List<String> userInput = user.parseUserInput();
        Calculator calculator = new Calculator();
        double result = calculator.calculateByOperator(userInput);
        System.out.println(result);
    }
}
