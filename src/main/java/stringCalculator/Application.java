package stringCalculator;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        UserInputValue input = new UserInputValue();
        Calculator calculator = new Calculator();

        final List<String> userInput = input.userInput();
        int result = calculator.calculateByOperator(userInput);

        System.out.println(userInput);
        System.out.println(result);
    }
}
