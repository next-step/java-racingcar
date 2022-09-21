package string;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        return convertNumber(text);
    }

    private static int convertNumber(String text) {
        int result = 0;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IncludeNotNumberException(text);
        }
        return result;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

}
