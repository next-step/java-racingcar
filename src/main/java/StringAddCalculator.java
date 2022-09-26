import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
* {} 없는 if문은 어떻게 생각하시나요?
* */
public class StringAddCalculator {

    private static final String DEFAULT_SEPARATORS = ",|:";
    private static final String CUSTOM_SEPARATOR_FINDERS = "//(.)\n(.*)";

    public static int splitAndSum(String text){
        if(isNullOrEmptyString(text)) return 0;
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_FINDERS).matcher(text);
        if(m.find()){
            String customDelimiter = m.group(1);
            String tempStr = m.group(2);
            return sum(toInts(split(customDelimiter, tempStr)));
        }
        return sum(toInts(split(DEFAULT_SEPARATORS, text)));
    }

    private static String[] split(String customDelimiter, String tempStr) {
        return tempStr.split(customDelimiter);
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int toInt(String text) {
        int result = Integer.parseInt(text);
        if (result < 0) throw new RuntimeException("NEGATIVE NUMBER");
        return result;
    }

    private static int[] toInts(String[] tokens) {
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = toInt(tokens[i]);
        }
        return result;
    }

    private static boolean isNullOrEmptyString(String text) {
        return text == null || text.isEmpty();
    }

}
