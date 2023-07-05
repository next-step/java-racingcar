package calculator;

public class Calculator {
    public static int sum(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        Numbers numbers = Numbers.of(Parser.parse(text));

        return numbers.sumAll();
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
