package calc;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator extends Calculator {

    public static int calculate(String expression) {

        int index = 0;

        // 주어진 식이 올바른 형식의 식인지 확인
        Matcher.matches(expression);

        // 주어진 식의 공백 제거
        expression = Processor.replaceWhitespaceCharacters(expression);

        // 주어진 식에서 숫자만 추출
        final int[] numbers = splitNumbers(expression);

        // 주어진 식에서 부호만 추출
        final String[] operations = Separator.splitOperations(expression);

        if (numbers.length == 1) {
            return numbers[0];
        }

        if (operations.length == 1) {
            if (operations[0].equals("+")) {
                return numbers[0];
            }

            return - numbers[0];
        }

        // 첫 번째 숫자가 음수인지 확인한다
        if (expression.startsWith("-")) {
            numbers[0] *= -1;
            index++;
        }

        for (int i = index; i < numbers.length - 1; i++) {
            numbers[index + 1] = operate(numbers[index], numbers[index + 1], operations[index]);
        }

        return numbers[numbers.length - 1];
    }

    private static int operate(int pre, int post, String operation) {
        switch (operation) {
            case "+" : return add(pre, post);
            case "-" : return subtract(pre, post);
            case "*" : return multiply(pre, post);
            case "/" : return divide(pre, post);
            default : return 0;
        }
    }

    private static int[] splitNumbers(final String expression) {
        final String[] numbers = Separator.splitNumbers(expression);

        Stream<String> stream = Arrays.stream(numbers);

        // 음수로 시작하는 경우 첫 번째 숫자의 배열이 공백이 된다.
        // 이 첫 번째 공백을 넘기기 위해 skip(1)을 한다
        if (expression.startsWith("-")) {
            stream = stream.skip(1);
        }

        return stream.mapToInt(Integer::parseInt).toArray();
    }
}
