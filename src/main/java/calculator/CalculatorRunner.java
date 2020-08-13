package calculator;

public class CalculatorRunner {

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator("2 + 3 * 4 / 2");
        System.out.println(calculator.execute());
    }
}
