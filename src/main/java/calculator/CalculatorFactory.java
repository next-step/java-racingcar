package calculator;

public class CalculatorFactory {

    public static Calculator calculator(String str) {
        if (str.contains(Constants.CUSTOMIZED_SEPARATOR_PREFIX)
                && str.contains(Constants.CUSTOMIZED_SEPARATOR_SUFFIX)) {
            return new CustomizedTokenCalculator();
        }
        return new SimpleCalculator();
    }
}
