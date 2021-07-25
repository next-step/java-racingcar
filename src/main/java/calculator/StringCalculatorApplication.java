package calculator;

import calculator.service.StringCalculator;
import java.util.Scanner;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        int result = calculator.execute(expression);

        System.out.println("result :: " + result);

    }
}
