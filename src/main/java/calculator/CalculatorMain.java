package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        int result = doStringCalculate(value);

        System.out.println(result);
    }

    private static int doStringCalculate(String value) {
        int result = -11111;
        StringCalculator stringCalculator = new StringCalculator();

        if(stringCalculator.patternMatcher(value)) {
            stringCalculator.calculate(value);
            result = stringCalculator.getResult();
        }

        return result;
    }
}
