import calculator.Calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("수식: ");
        String expression = scanner.nextLine();

        int operationResult = Calculator.calculate(expression);
        System.out.println("연산결과: " + operationResult);
    }
}
