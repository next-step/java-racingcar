package calculator;

public class Calculator {
    private final Delimiter delimiter;

    public Calculator(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    public int calculate(String input) {
        if (isBlank(input)) {
            return 0;
        }

        delimiter.validate(input);

        return sum(toInts(delimiter.split(input)));
    }

    private boolean isBlank(String input) {
        return input == null || input.isEmpty() || input.equals("null");
    }

    private int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
