package calculator;

public class StringCalculator {
    private StringCalculator() {
    }

    public static void checkInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("올바르지 않는 입력값 입니다.");
        }
    }

    public static long calculate(String input) {
        checkInput(input);
        String[] numbers = input.split(" ");
        long x = Long.parseLong(numbers[0]);
        for (int i = 1; i < numbers.length; i += 2) {
            Operation operation = Operation.findOperation(numbers[i]);
            long y = Long.parseLong(numbers[i + 1]);
            x = operation.calculate(x, y);
        }
        return x;
    }

}
