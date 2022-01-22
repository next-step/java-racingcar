package calculator;

import java.io.IOException;

public class Application {

    static Printer printer = new Printer();

    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();

        Separator separator = new Separator();
        separator.separate(userInput.inputArr);

        Number number = separator.getNumberInstance();
        Operator operator = separator.getOperatorInstance();

        Calculator calculator = new Calculator();

        double output = calculator.doMultipleOperation(number, operator);
        printer.printOutputMessage(output);
    }
}
