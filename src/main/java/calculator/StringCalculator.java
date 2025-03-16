package calculator;

public class StringCalculator {

    public static final String DELIMITER = ",|:";

    public static int calculate(String text) {
        String checkedText = emptyOrNullChecker(text);
        if (checkedText.contains(",") || checkedText.contains(":")) {
            return getSum(checkedText);
        }
        return Integer.parseInt(emptyOrNullChecker(checkedText));
    }

    private static int getSum(String text) {
        String[] values = text.split(DELIMITER);
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value.trim());
        }
        return result;
    }

    private static String emptyOrNullChecker(String text){
        if (text == null || text.isEmpty()) {
            return "0";
        }
        return text;
    }
}
