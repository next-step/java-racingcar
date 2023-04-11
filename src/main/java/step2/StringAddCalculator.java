package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_REGEX = "[,:]";
    public static final Pattern CUSTOM_REGEX = Pattern.compile("//(.)\n(.*)");


    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) return 0;
        return divideText(text);
    }

    public static int sumSingleNumber(String[] singleNumber) {
        return validatePositive(singleNumber[0]);
    }

    public static int sumMultipleNumbers(int[] checkedNumbers) {
        return Arrays.stream(checkedNumbers).sum();
    }


    public static int divideText(String text) {
        Matcher matcher = CUSTOM_REGEX.matcher(text);
        if(matcher.find()) {
            return convertTextToInt(matcher.group(2).split(matcher.group(1)));
        }
        return classifyNumbers(text.split(DEFAULT_REGEX));
    }

    public static int classifyNumbers(String[] numbers) {
        if(numbers.length == 1) return sumSingleNumber(numbers);
        return convertTextToInt(numbers);
    }

    public static int convertTextToInt(String[] numbers) {
        int[] checkedNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            checkedNumbers[i] = validatePositive(numbers[i]);
        }
        return sumMultipleNumbers(checkedNumbers);
    }

    public static int validatePositive(String num) {
        try {
            int number = Integer.parseInt(num);
            if (number < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만 입력해주세요");
        }
    }
}
