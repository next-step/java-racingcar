package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Calculator calculator = new Calculator();
        Integer result = calculator.calculate(input);
        System.out.printf("실행결과 : %d", result);
    }
}
