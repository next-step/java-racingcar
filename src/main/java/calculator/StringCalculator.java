package calculator;

public class StringCalculator {

    public static int execute(String expression) {
        ExpressionProcessor processor = new ExpressionProcessor(expression);
        return calculate(processor.getNumbers(), processor.getOperators());
    }

    public static void main(String[] args) {
        System.out.println(StringCalculator.execute("2 + 3 * 4 / 2"));
    }

    // 테스트를 위하여 접근 지정자를 public으로 설정
    public static int calculate(int[] numbers, Operator[] operators) {
        if (isNotValidExpression(numbers, operators)) {
            throw new IllegalArgumentException(ExceptionMessage.INCORRECT_NUMBER_OF_ARGUMENTS.getMessage());
        }
        int accumulator = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            accumulator = operators[i].compute(accumulator, numbers[i + 1]);
        }
        return accumulator;
    }

    private static boolean isNotValidExpression(int[] numbers, Operator[] operators) {
        return numbers.length != operators.length + 1;
    }

    private StringCalculator() {}
}
