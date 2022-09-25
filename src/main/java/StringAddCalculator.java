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
                .map(StringAddCalculator::convertStringToInteger)
                .reduce(0, Integer::sum);
    }

    private static int convertStringToInteger(String numberString) throws RuntimeException {
        return isValidNumberString(numberString) ? Integer.parseInt(numberString) : 0;
    }

    private static boolean isValidNumberString(String numberString){
        // 양수인지 검증
        if(! isPositiveNumber(numberString)){
            throw new RuntimeException("Wrong Input");
        }
        return true;
    }

    private static boolean isPositiveNumber(String numberString){
        return positiveNumberPattern.matcher(numberString).find();
    }

}

