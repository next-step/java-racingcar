import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String numbersString){
        if(isEmpty(numbersString)){
            return 0;
        }

        String[] numberStringArray = split(numbersString);
        return sum(numberStringArray);
    }

    private static boolean isEmpty(String string){
        if(string == null){
            return false;
        }
        if(string.isEmpty()){
            return false;
        }
        return true;
    }

    private static String[] split(String numberString){
        Matcher matcher = pattern.matcher(numberString);

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

    // String -> int 형변환. 음수이거나 숫자가 아니면 예외 발생
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

