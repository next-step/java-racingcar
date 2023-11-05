package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static String REGEX = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        text = getTextWithOutCustomGroup(text);
        return sum(toInts(split(text)));
    }

    private static String getTextWithOutCustomGroup(String text) {
        Pattern r = Pattern.compile("//(.)\n(.*)");
        Matcher m = r.matcher(text);
        if (m.find()) {
            addRegex(m);
            return m.group(2);
        }
        return text;
    }

    private static void addRegex(Matcher m) {
        REGEX += "|" + m.group(1);
    }

    private static String[] split(String text) {
        return text.split(REGEX);
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
            checkDegitOrMinus(values[i]);
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static void checkDegitOrMinus(String value) {
        if (!value.matches("-?\\d+")) {
            throw new RuntimeException("숫자 타입이 아닙니다.");
        }
        if (Integer.parseInt(value) < 0) {
            throw new RuntimeException("음수입니다.");
        }
    }
}
