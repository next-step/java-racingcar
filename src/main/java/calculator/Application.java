package calculator;

import calculator.domain.Calculator;
import calculator.view.UserInput;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final UserInput userInput = new UserInput(new Scanner(System.in));
        final Calculator calculator = new Calculator(userInput);
        calculator.calculate();
    }
}
