package calculator;

import java.util.function.Function;

/**
 * @author : 김윤호
 * @version :
 * @date : 2019-10-25 18:39
 */
public class StringCalculator {

    public static double calculate(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("Invalid Argument");
        }
        return calculate(inputString.split(" "));
    }

    private static final double calculate(String... splitText) {
        final Function<String, Double> stringToInt = str -> Double.parseDouble(str);
        double resultValue = stringToInt.apply(splitText[0]);
        for (int i = 1; i < splitText.length; i += 2) {
            resultValue = Calculator.findOperator(splitText[i]).calculate(resultValue, stringToInt.apply(splitText[i + 1]));
        }
        return resultValue;
    }
}
