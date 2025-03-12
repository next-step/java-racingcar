package calculator;

import calculator.exception.NotPositiveNumberException;

public class StringAddCalculator {

    private StringAddCalculator() {

    }

    public static int sum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] numbers = StringParser.splitNumberString(text);
        int sum = 0;

        for (String s : numbers) {
            int number = Integer.parseInt(s);
            if (number < 0) {
                throw new NotPositiveNumberException();
            }
            sum += number;
        }
        return sum;
    }
}
