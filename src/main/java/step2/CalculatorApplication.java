package step2;

import step2.domain.Calculator;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Calculator calculator = Calculator.create();
        System.out.println("수식을 입력해 주세요");
        calculator.input(scanner.nextLine());
        int result = calculator.calculate();
        System.out.println("result = " + result);
        scanner.close();
    }
}
