package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String DELIMITER_1 = ",";
    public static final String DELIMITER_2 = ":";

    /**
     * indent 1이하
     * else 없이
     * private 는 public을 통해 테스트한다. ( private도 할때도 있긴함 )
     */

    public static int cal(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(convertDefaultDelimiters(checkAndConvertCustomDelimiter(text)))));
    }

    private static String checkAndConvertCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return convertDelimiter(m.group(1), m.group(2));
        }
        return text;
    }

    private static String convertDefaultDelimiters(String text){
        return convertDelimiter(DELIMITER_2,text);
    }

    private static String convertDelimiter(String customDelimiter, String text) {
        return text.replaceAll(customDelimiter, DELIMITER_1);
    }

    private static String[] split(String text) {
        String[] strArray = text.split(DELIMITER_1);
        vaildate(strArray);
        return strArray;
    }

    private static void vaildate(String[] strArray) {
        for (String str : strArray){
            checkException(str);
        }
    }

    private static void checkException(String str) {
        if(!Pattern.compile("\\d").matcher(str).find()){
            throw new RuntimeException("올바르지 않은 문자입력 : " + str);
        }
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        negativeValueValidation(numbers);
        return numbers;
    }

    private static void negativeValueValidation(int[] intArray) {
        for (int val : intArray) {
            if (val < 0) {
                throw new RuntimeException("올바르지 않은 문자입력 : " + val);
            }
        }
    }
}
