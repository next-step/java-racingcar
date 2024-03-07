package step2;

public class StringAddCalculator {

    public static int calculate(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        if (text.length() == 1) {
           return Integer.parseInt(text);
        }

        return sum(text);
    }

    private static int sum(String text) {
        String[] numbers = text.split("[,≠:]");
        int number = 0;
        for (String s : numbers) {
            number += Integer.parseInt(s);
        }
        return number;
    }

}
