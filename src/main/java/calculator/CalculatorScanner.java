package calculator;

import java.util.Scanner;

class CalculatorScanner {
    private static final CalculatorScanner calculatorScanner = new CalculatorScanner();

    private CalculatorScanner() {
    }

    public static CalculatorScanner getInstance() {
        return calculatorScanner;
    }

    public String enter() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine().trim();
        }
    }
}
