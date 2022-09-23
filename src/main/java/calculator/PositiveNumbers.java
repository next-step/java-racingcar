package calculator;

public class PositiveNumbers {

    private final int[] numbers;

    public PositiveNumbers(int[] numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public PositiveNumbers(String[] values) {
        this(ofStringValues(values));
    }

    public int sum() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static void validate(int[] numbers) {
        for (int number : numbers) {
            validateNumberIsPositive(number);
        }
    }

    private static void validateNumberIsPositive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력될 수 없습니다.");
        }
    }

    private static int[] ofStringValues(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = fromStringValue(values[i]);
        }
        return numbers;
    }

    private static int fromStringValue(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("숫자 이의의 값은 입력될 수 없습니다.");
        }
        return number;
    }
}
