package calculator;

import calculator.service.CalculatorCore;
import calculator.service.CalculatorView;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        System.out.println(doStringCalculate(value));
    }

    private static int doStringCalculate(String value) {
        int result = 0;

        try {
            String[] values = CalculatorView.parseInputValues(value);

            result = CalculatorCore.createExpression(values);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }

        return result;
    }
}
