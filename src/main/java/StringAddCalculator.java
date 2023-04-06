import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private StringAddCalculator(){}
    public static int splitAndSum(String input) {
        // validation
        if (isInputNull(input)||isInputEmpty(input)) return 0;
        if(isOnlyNumber(input)) return Integer.parseInt(input);

        return getSum(convertNumber(input));
    }

    private static String[] getCustomDelimiterNumbers(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String inputNumberText = m.group(2);
            return inputNumberText.split(customDelimiter);
        }
        return null;
    }

    private static boolean isOnlyNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static String[] convertNumber(String input){
        String[] numbers = getCustomDelimiterNumbers(input);
        if(numbers == null){
            numbers = input.split(DEFAULT_DELIMITER);
        }
        return numbers;
    }
    private static int getSum(String[] numbers){
        return Arrays.stream(numbers)
                .mapToInt(number -> {
                    try {
                        return getNumberFromString(number);
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                })
                .sum();
    }

    private static boolean isInputNull(String input){
        return (input == null)?true:false;
    }

    private static boolean isInputEmpty(String input){
        return (input.isEmpty())?true:false;
    }

    private static int getNumberFromString(String number) {
        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }

        int num = Integer.parseInt(number);

        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습ㄴ다.");
        }

        return num;
    }
}
