package calc;

import java.util.Arrays;
import java.util.stream.Stream;

import static calc.StringUtils.EMPTY;

public final class StringCalculator extends Calculator {

    private StringCalculator() {}

    public static int calculate(String expression) {

        // 주어진 식의 공백 제거
        expression = StringUtils.replaceWhitespaceCharacters(expression);

        // 주어진 식이 올바른 형식의 식인지 확인
        Validator.validate(expression);

        // 주어진 식에서 숫자만 추출
        final int[] numbers = convertToIntArray(expression);

        // 주어진 식에서 부호만 추출
        final String[] operators = Separator.splitOperators(expression);

        // 계산
        return compute(numbers, operators);
    }

    private static int compute(int[] numbers, String[] operators) {

        // 하나의 숫자만 입력으로 받은 경우 바로 리턴한다
        if (operators.length == 0) {
            return numbers[0];
        }

        // 첫 번째 숫자가 음수인지 확인한다
        // 두 배열의 길이가 같으면 첫 번째 숫자 앞에 부호가 달려있다
        if (numbers.length == operators.length && operators[0].equals(MINUS)) {
            numbers[0] *= -1;
        }

        for (int index = 0; index < numbers.length - 1; index++) {

            // 연산 부호는 항상 1번 인덱스부터 시작한다
            numbers[index + 1] = operate(numbers[index], numbers[index + 1], operators[index + 1]);
        }

        return numbers[numbers.length - 1];
    }

    private static int[] convertToIntArray(String expression) {
        String[] numbers = Separator.splitNumbers(expression);
        Stream<String> stream = Arrays.stream(numbers);
        if (numbers[0].equals(EMPTY)) {
            stream = stream.skip(1);
        }

        return stream.mapToInt(Integer::parseInt).toArray();
    }
}
