package study.stringCalculator;

public class StringCalculator {

    private final int ZERO_RESULT = 0;
    private Splitter splitter;

    public StringCalculator() {
        splitter = new Splitter();
    }

    public int calculate(String input_string) {
        if (isEmpty(input_string)) {
            return ZERO_RESULT;
        }
        int[] numbers = splitter.getNumbers(input_string);

        return getSum(numbers);
    }

    private boolean isEmpty(String expression) {
        return expression == null || expression.isBlank();
    }

    private int getSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum = add(sum, number);
        }
        return sum;
    }

    private int add(int sum, int number) {
        return sum + number;
    }

}
