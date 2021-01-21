package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputHandler input = new InputHandler(new Scanner(System.in));
        Calculator calculator = new Calculator();

        String formula = input.getFormula();
        Double answer = calculator.getAnswer(formula);

        System.out.printf("결과는: %s%n", answer.toString());
    }
}
