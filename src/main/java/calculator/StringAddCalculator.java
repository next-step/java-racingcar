package calculator;

public class StringAddCalculator {

    public static int splitAndAddString(String numbersText) {
        if (numbersText == null || numbersText.isEmpty()) {
            return 0;
        }

        String[] numbers = numbersText.split(",|:");
        int result = 0;

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}
