package calculator;

import java.io.IOException;

public class Application {

    static Printer printer = new Printer();

    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();

        Extractor extractor = new Extractor();
        Number number = extractor.extractNumbers(userInput.splittedInput);
        Operator operator = extractor.extractOperators(userInput.splittedInput);

        Calculator calculator = new Calculator();

        double output = calculator.doMultipleOperation(number, operator);
        printer.printOutputMessage(output);
    }
}
