package calculator;

import java.io.IOException;

public class Application {

    static Printer printer = new Printer();

    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();

        Extractor extractor = new Extractor();
        Number numbers = extractor.extractNumbers(userInput.splittedInput);
        Symbol symbols = extractor.extractSymbols(userInput.splittedInput);

        Calculator calculator = new Calculator();

        double output = calculator.doMultipleOperation(numbers, symbols);
        printer.printOutputMessage(output);
    }
}
