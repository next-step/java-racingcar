package camp.nextstep.edu.calculator;

import java.util.Scanner;

public class CalculatorApplication {
    private final Calculator<Integer> calculator;

    public CalculatorApplication(Calculator<Integer> calculator) {
        this.calculator = calculator;
    }

    public static void main(String[] args) {
        final Validator<String> validator = new ExpressionValidator();
        final Calculator<Integer> calculator = new StringCalculator(validator);
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
