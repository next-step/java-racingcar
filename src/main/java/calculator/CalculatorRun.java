package calculator;

import java.util.Scanner;

public class CalculatorRun {

    public static void main(String[] args) {
        System.out.println("수식을 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Calculator calculator = new Calculator(input);
        double result = calculator.calculate();

        System.out.println("값 = " + result);
    }
}
