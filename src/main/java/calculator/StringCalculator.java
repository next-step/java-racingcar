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

    private static final int FIRST_VALUE = 0;

    public static double calculate(String inputString) {
        if (inputString == null || inputString.replaceAll(" ", "").isEmpty()) {
            throw new IllegalArgumentException("숫자나 오퍼레이터만 넣어주세요.");
        }

        String[] values = inputString.split(" ");

        if (!checkValues(values)) {
            throw new IllegalArgumentException("숫자나 오퍼레이터만 넣어주세요.");
        }

        return calculate(values);
    }

    private static final double calculate(String... splitText) {
        double resultValue = Double.parseDouble(splitText[FIRST_VALUE]);
        for (int i = 1; i < splitText.length; i += 2) {
            resultValue = Calculator.findOperator(splitText[i]).calculate(resultValue, Double.parseDouble(splitText[i + 1]));
        }
        return resultValue;
    }

    private static boolean checkValues(String... splitText) {
        return Arrays.stream(splitText)
                .allMatch(value -> RegxUtils.isNumeric(value) || RegxUtils.isOperator(value));
    }
}
