package calculator;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        User user = new User();
        final List<String> userInput = user.getUserInput();
        System.out.println(userInput);
        Calculator calculator = new Calculator();
        int result = calculator.calculateByOperator(userInput);
        System.out.println(result);
    }
}
