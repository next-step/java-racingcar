package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int calculate(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }

        Matcher matcher = getMatcher(input);

        if(matcher.find()){
            return sumArrayValue(stringToInt(splitByPatten(matcher)));
        }

        return sumArrayValue(stringToInt(split(input)));
    }

    private Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        return matcher;
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private String[] split(String input) {
        String[] split = input.split(",|:");
        return split;
    }
    private String[] splitByPatten(Matcher matcher) {
        return matcher.group(2).split(matcher.group(1));
    }

    private int[] stringToInt(String[] array) {
        int length = array.length;
        int[] result = new int[length];

        for (int i = 0; i <length ; i++) {
            int value = Integer.parseInt(array[i]);
            validNegative(value);
            result[i] = value;
        }

        return result;
    }

    private void validNegative(int value) {
        if (value < 0) {
            throw new RuntimeException("입력값이 음수일수 없습니다.");
        }
    }

    private int sumArrayValue(int[] array) {
        int sum = 0;

        for (int value: array) {
            sum += value;
        }

        return sum;
    }


}
