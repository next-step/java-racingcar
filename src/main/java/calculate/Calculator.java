package calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Calculator {

    static String COMMA = ",";
    static String COLONS = ":";
    boolean hasCustomDelimiter(String input) {

        if (input.length() < 3) return false;
        Matcher m = Pattern.compile("₩₩(.)\n(.*)").matcher(input);
        return m.find();
    }

    String getCustomDelimiter(String input) {
        return input.substring(2,3);
    }

    String getGeneralDelimiter(String input) {
        return input.contains(COMMA) ? COMMA: COLONS;
    }

    int[] getNumbers(String input, String delimiter) {

        String[] stringPart = input.split(delimiter);
        return Stream.of(stringPart).mapToInt(Integer::parseInt).toArray();
    }

    boolean hasOnlyNumber(String[] input){ // 음수 또는 숫자 이외의 값을 포함하는지

        for (String s : input) {
            if (!isInteger(s) || (parseInt(s) < 0)) {
                return false;
            }
        }
        return true;
    }

    boolean isInteger(String s) {
        try {
            parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    int getSum(int[] input) { // 합
        return 0;
    }

    boolean isNullOrEmpty(String input) { // null 이나 빈문자열이라면 0 리턴
        return (input == null) || (input.isBlank());
    }

}
