package calculator;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();
        Seperator seperator = new Seperator();
        seperator.seperate(userInput.inputList);
        Calculator calculator = new Calculator();

        double result = calculator.doMultipleOperation(seperator.number.numbers, seperator.operator.operators);
        System.out.println(result);
    }
}
