package calculator;

import calculator.application.CalculatorService;
import calculator.validator.StringValidator;

import java.util.Scanner;

public class CalculatorApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();
        StringValidator.validateForBlank(input);
        var result = CalculatorService.calculate(input);
        System.out.println(result);
    }
}
