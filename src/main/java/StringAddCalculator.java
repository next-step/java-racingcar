import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String target) {
        if(target == null || target.isBlank()) {
            return 0;
        }

        if(target.length() == 1) {
            return convertToInt(target);
        }

        Matcher m = pattern.matcher(target);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return sum(tokens);
        }

        String[] splitResults = target.split(",|:");
        return sum(splitResults);


    }

    private static int sum(String[] numberStr) {
        int sum = 0;
        for (String s : numberStr) {
            int targetNum = convertToInt(s);
            if (targetNum < 0) {
                throw new RuntimeException("인자로 받는 숫자는 모두 양수여야 합니다.");
            }
            sum += targetNum;
        }
        return sum;
    }

    private static int convertToInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch(NumberFormatException e) {
            throw new RuntimeException("숫자 형태의 문자만 인자로 받을 수 있습니다.");
        }
    }
}
