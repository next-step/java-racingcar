import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static Pattern separatePattern = Pattern.compile("//(.)\n(.*)");
    private static Pattern positiveNumberPattern = Pattern.compile("^[0-9]\\d*(\\.\\d+)?$");

    public static int splitAndSum(String numbersString){
        if(isEmpty(numbersString)){
            return 0;
        }
        return sum(split(numbersString));
    }

    private static boolean isEmpty(String string){
        return string == null || string.isEmpty();
    }

    private static String[] split(String numberString){
        Matcher matcher = separatePattern.matcher(numberString);

        // 커스텀 구분자로 Split
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        // 일반 구분자로 Split
        return numberString.split(",|:");
    }

    private static int sum(String[] numberStringArray){
        return Arrays.stream(numberStringArray)
                .map(StringAddCalculator::getInteger)
                .reduce(0, Integer::sum);
    }

    // String -> int 형변환
    private static int getInteger(String numberString) throws RuntimeException {
        int number;
        try {
            number = Integer.parseInt(numberString);
            if(number < 0 ){
                throw new RuntimeException("Wrong Input: Negative Number");
            }
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("Wrong Input: Not Number");
        }
        return number;
    }

}

