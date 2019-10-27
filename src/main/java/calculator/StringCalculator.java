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
    private static final Function<String[], Integer> LAST_VALUE_INDEX = str -> str.length - 1;
    private static final String EMPTY_STRING = "";
    private static final String BLANK_STRING = " ";

    public static double calculate(String inputString) {
        if (inputString == null || inputString.replaceAll(BLANK_STRING, EMPTY_STRING).isEmpty()) {
            throw new IllegalArgumentException("null이나 빈 문자열을 입력할 수 없습니다.");
        }
          
        String[] values = inputString.split(" ");

        if (!checkValues(values)) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다.");
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
        if (!CheckUtil.isNumeric(splitText[FIRST_VALUE]) || !CheckUtil.isNumeric(splitText[LAST_VALUE_INDEX.apply(splitText)])) {
            return false;
        }

        return Arrays.stream(splitText)
                .allMatch(value -> CheckUtil.isNumeric(value) || CheckUtil.isOperator(value));
    }
}
