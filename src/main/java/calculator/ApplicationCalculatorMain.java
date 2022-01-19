package calculator;

import java.util.List;

public class ApplicationCalculatorMain {

    public static void main(String[] args) {
        Console console = new Console();

        List<String> splitedInput = console.readLine();

        Calculator calculator = new Calculator(splitedInput);

        console.printResult(calculator.getResult());
    }
}
