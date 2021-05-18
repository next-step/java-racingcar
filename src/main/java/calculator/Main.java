package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("input : ");
        String input = scanner.nextLine();

        calculator.handleNullException(input);
        calculator.handleOperatorException(input);
        calculator.handleNumberOperatorException(input);

        System.out.println("결과값 : " + calculator.calculate(input));
    }
}
