package calculator;

public class CalculatorFactory {

    public static Calculator calculator(String str) {
        if (str.contains("//") && str.contains("\n")) {
            return new CustomizedTokenCalculator();
        }
        return new SimpleCalculator();
    }
}
