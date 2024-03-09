package stringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        String[] numbers = text.split(",|:");
        int result = 0;

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }

    private static boolean isNullOrEmpty(String text) {
        return (text == null) || (text.isEmpty());
    }


}
