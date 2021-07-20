package calculator;

public class CalculatorRunner {
    public static void main(String[] args) {
        System.out.println(Calculator.from(CalculatorScanner.getInstance().enter()).calculate());
    }
}
