package calculator;

public class CalculatorRunner {

    public static void main(String[] args) {
        MathematicalExpression expression = new MathematicalExpression("2 + 3 * 4 / 2");
        StringCalculator calculator = new StringCalculator(expression);
        System.out.println(calculator.execute());
    }
}
