package stringCalculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int result;
        User user = new User();
        final List<String> userInput= user.getUserInput();
        System.out.println(userInput);
        Calculator calculator= new Calculator();
        result= calculator.calculateByOperator(userInput);
        System.out.println(result);
    }
}
