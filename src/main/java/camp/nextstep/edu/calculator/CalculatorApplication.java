package camp.nextstep.edu.calculator;

import java.util.Scanner;

public class CalculatorApplication {
    private final StringCalculator<Integer> calculator;

    public CalculatorApplication(StringCalculator<Integer> calculator) {
        this.calculator = calculator;
    }

    public static void main(String[] args) {
        final ExpressionValidator validator = new ExpressionValidatorImpl();
        final StringCalculator<Integer> calculator = new SequentialCalculator(validator);
        final CalculatorApplication application = new CalculatorApplication(calculator);

        application.run();
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            final String inputString = scanner.nextLine();
            final Integer result = calculator.calculate(inputString);
            System.out.println(result);
        } catch (Exception ex) {
            System.out.println("Failed to calculate. errorMessage:" + ex.getMessage());
        }
    }
}
