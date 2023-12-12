package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern INPUT_PATTERN = Pattern.compile("//(.*)\\n(.*)");
    public static final String DEFAULT_SEPARATOR = ",|:";
    public int calculate(String input){
        if (input == null || input.isBlank()){
            return 0;
        }
        String separator = parseSeparator(input);
        String[] numbers = input.split(separator);
        if (checkNegative(numbers)){
            throw new RuntimeException("음수를 입력하셨습니다.");
        }
        int result = sumInts(parseInts(numbers));
        return result;
    }

    private int[] parseInts(String[] numbers){
        int[] intArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int number = parseInt(numbers[i]);
            intArray[i] = number;
        }
        return intArray;
    }

    private int parseInt(String number){
        try {
            return checkBlank(number);
        } catch (NumberFormatException exception){
            throw new NumberFormatException("숫자가 아닌 문자가 있습니다.");
        }
    }

    private int sumInts(int[] parsedNumbers){
        int sum = 0;
        for (int parsedNumber : parsedNumbers) {
            sum += parsedNumber;
        }
        return sum;
    }

    private String parseSeparator(String input){
        Matcher matcher = INPUT_PATTERN.matcher(input);
        if (matcher.find()){
            return matcher.group(1);
        }
        return DEFAULT_SEPARATOR;
    }

    private boolean checkNegative(String[] numbers){
        CharSequence minusSign = "-";
        for (String number:numbers) {
            if (number.contains(minusSign)){
                return true;
            }
        }
        return false;
    }

    private int checkBlank(String number){
        if(number.isBlank()){
            return 0;
        }
        return Integer.parseInt(number);
    }
}
