package calculator;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * @author : 김윤호
 * @version :
 * @date : 2019-10-25 18:39
 */
public class StringCalculator {
    public static double calculate(String inputString) {
        if (inputString == null || inputString.replaceAll(" ", "").isEmpty()) {
            throw new IllegalArgumentException("Invalid Argument");
        }

        String[] values = inputString.split(" ");

        if (!checkValues(values)) {
            throw new IllegalArgumentException("숫자나 오퍼레이터만 넣어주세요.");
        }

        return calculate(values);
    }

    private static final double calculate(String... splitText) {
        final Function<String, Double> stringToInt = str -> Double.parseDouble(str);
        double resultValue = stringToInt.apply(splitText[0]);
        for (int i = 1; i < splitText.length; i += 2) {
            resultValue = Calculator.findOperator(splitText[i]).calculate(resultValue, stringToInt.apply(splitText[i + 1]));
        }
        return resultValue;
    }

    private static boolean checkValues(String... splitText) {
        return Arrays.stream(splitText)
                .allMatch(value -> RegxUtils.isNumeric(value) || RegxUtils.isOperator(value));
    }
}
