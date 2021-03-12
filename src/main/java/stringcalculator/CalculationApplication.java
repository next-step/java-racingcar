package stringcalculator;

import java.util.Scanner;


public class CalculationApplication {

    public static void main(String[] args) {
        CalculationApplication calculationApplication = new CalculationApplication();

        String request = calculationApplication.takeCalculateRequest();

        IntCalculator calculator = new IntCalculator(request);
        int result = calculator.calculateInOrderFromTheLeft();

        calculationApplication.printResult(result);
    }

    private String takeCalculateRequest() {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            shouldNotBeNullOrBlank(input);
            return input;
        }
    }

    void shouldNotBeNullOrBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void printResult(int result) {
        System.out.println(result);
    }
}
