package calc;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator extends Calculator {

    public static int calculate(String expression) {

        // 주어진 식이 올바른 형식의 식인지 확인
        Matcher.matches(expression);

        // 주어진 식의 공백 제거
        expression = Processor.replaceWhitespaceCharacters(expression);

        // 주어진 식에서 숫자만 추출
        final int[] numbers = convertToIntArray(expression);

        // 주어진 식에서 부호만 추출
        final String[] operations = Separator.splitOperations(expression);

        // 계산
        return compute(numbers, operations);
    }

    private static int compute(int[] numbers, String[] operations) {

        // 첫 번째 숫자가 음수인지 확인한다
        // 두 배열의 길이가 같지 않으면 첫 번째 숫자 앞에 부호가 달려있다
        if (numbers.length != operations.length && operations[0].equals("-")) {
            numbers[0] *= -1;
        }

        for (int index = 0; index < numbers.length - 1; index++) {

            // 연산 부호는 항상 1번 인덱스부터 시작한다
            numbers[index + 1] = operate(numbers[index], numbers[index + 1], operations[index + 1]);
        }

        return numbers[numbers.length - 1];
    }

    private static int[] convertToIntArray(String expression) {
        String[] numbers = Separator.splitNumbers(expression);
        Stream<String> stream = Arrays.stream(numbers);
        if (numbers[0].equals("")) {
            stream = stream.skip(1);
        }

        return stream.mapToInt(Integer::parseInt).toArray();
    }

    private static int operate(int pre, int post, String operation) {
        switch (operation) {
            case "+":
                return add(pre, post);
            case "-":
                return subtract(pre, post);
            case "*":
                return multiply(pre, post);
            case "/":
                return divide(pre, post);
            default:
                return 0;
        }
    }
}
