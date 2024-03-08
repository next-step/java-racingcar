import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEF_REGEX = ",|:";
    private static final String ONE_CHAR_REGEX = "\\d+";
    private static final String EXCEPTION_MSG = "음수는 입력이 불가합니다!!";
    private static final int DEFAULT_VALUE = 0 ;
    private static final int SEPARATE_GROUP_ONE = 1;
    private static final int SEPARATE_GROUP_TWO = 2;

    public static int splitAndSum(String inData) {

        if (inData == null || inData.isBlank()) {
            return DEFAULT_VALUE;
        }

        if (isNumber(inData)) {
            return Integer.parseInt(inData);
        }

        return sumStringArray(splitInputString(inData));
    }

    private static boolean isNumber(String number){
        return number.matches(ONE_CHAR_REGEX);
    }

    private static String[] splitInputString(String inData) {
        Matcher m = CUSTOM_PATTERN.matcher(inData);

        if (m.find()) {
            String customDelimiter = m.group(SEPARATE_GROUP_ONE);
            String[] tokens = m.group(SEPARATE_GROUP_TWO).split(customDelimiter);

            return tokens;
        }
        return inData.split(DEF_REGEX);
    }

    private static int sumStringArray(String[] tokens) {
        int result = DEFAULT_VALUE;

        for (String token : tokens) {
            int num = Integer.parseInt(token);
            result += checkNegNum(num);
        }

        return result;
    }

    private static int checkNegNum(int trgNum) {
        if (trgNum < 0) {
            throw new IllegalArgumentException(EXCEPTION_MSG);
        }
        return trgNum;
    }

}
