import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER = "//(.)\\n(.*)";
    private static final String CUSTOM_SPLIT_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_GROUP_NUMBER = 1;
    private static final int REGEX_GROUP_NUMBER = 2;

    public static int splitAndSum(String inputCase) {

        int result = 0;

        if (checkNullAndBlank(inputCase)) {
            return result;
        }

        String[] regexArr = applyCustomRegexAndConvert(inputCase);
        List<Integer> intArr = convertStringArrToIntArr(regexArr);
        return sumAllElements(intArr);
    }

    private static boolean checkNullAndBlank(String inputCase) {
        return ((inputCase == null) || (inputCase.isEmpty()));
    }

    private static String[] applyCustomRegexAndConvert(String inputCase) {

        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(inputCase);

        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP_NUMBER);
            return m.group(REGEX_GROUP_NUMBER).split(customDelimiter);
        }
        return inputCase.split(CUSTOM_SPLIT_DELIMITER);
    }

    private static List<Integer> convertStringArrToIntArr(String[] inputCase) {

        List<Integer> convertedIntArr = new ArrayList<>();

        for (String stringNumber : inputCase) {
            int stringToInt = parseInt(stringNumber);
            checkNegativeInt(stringToInt);
            convertedIntArr.add(stringToInt);
        }
        return convertedIntArr;
    }

    private static int parseInt(String inputCase) {
        return Integer.parseInt(inputCase);
    }

    private static void checkNegativeInt(int convertedNumber) {
        if (convertedNumber < 0) {
            throw new NegativeNumberException("음수값입니다");
        }
    }

    private static int sumAllElements(List<Integer> inputCase) {
        return inputCase.stream().mapToInt(it -> it).sum();
    }
}
