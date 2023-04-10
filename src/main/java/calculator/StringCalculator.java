package calculator;

public class StringCalculator {

    public static final int ZERO = 0;
    public static String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if(isNullOrEpmty(text)){
            return ZERO;
        }
        return sum(split(text));
    }

    private static int sum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += toPositiveNumber(value);
        }
        return sum;
    }

    private static boolean isNullOrEpmty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        if(isCustom(text)){
            return customSplit(text);
        }
        return text.split(DELIMITER);
    }

    private static int toPositiveNumber(String value) {
        int number = Integer.parseInt(value);

        if(number<0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static boolean isCustom(String text) {
        return text.startsWith("//") && text.charAt(3) == '\n';
    }

    private static String[] customSplit(String text) {
        String customDelimiter = String.valueOf(text.charAt(2));
        return text.substring(4).split(customDelimiter);
    }
}
