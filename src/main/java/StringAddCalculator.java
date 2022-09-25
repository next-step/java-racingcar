import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

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
        String[] numberStringArray;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numberString);
        if (m.find()) {
            // 커스텀 구분자로 Split
            String customDelimiter = m.group(1);
            numberStringArray = m.group(2).split(customDelimiter);
        } else {
            // 일반 구분자로 Split
            numberStringArray= numberString.split(",|:");
        }

        return numberStringArray;
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

