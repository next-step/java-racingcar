package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/***
 * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현한 클래스
 */
public class StringCalculator {

    private enum Operator {
        PLUS("+", (param1, param2) -> param1 + param2),
        MINUS("-", (param1, param2) -> param1 - param2),
        MULTIPLY("*", (param1, param2) -> param1 * param2),
        DIVIDE("/", (param1, param2) -> param1 / param2);

        private String value;
        private BiFunction<Integer, Integer, Integer> expression;

        Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
            this.value = operator;
            this.expression = expression;
        }

        public Integer apply(int param1, int param2) {
            return this.expression.apply(param1, param2);
        }

        static Operator toEnum(String operator) {
            return Arrays.stream(values())
                    .filter(enumeration -> enumeration.value.equals(operator))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(String.format("올바르지 않은 사칙연산자 입니다. [%s]", operator)));
        }
    }

    /***
     * 문자열의 유효성을 검사한다.
     * @param text
     * @return
     */
    private void valid(String text) {
        if (isEmptyString(text) || isBlankString(text))
            new IllegalArgumentException(String.format("올바르지 입력 문자입니다. [%s]", text));
    }

    /***
     * 문자열의 null 또는 빈문자열 여부를 판별한다.
     * @param string
     * @return
     */
    private boolean isEmptyString(String string) {
        return string == null || string.isEmpty();
    }

    /***
     * 문자열의 null 또는 공백 문자열 여부를 판별한다.
     * @param string
     * @return
     */
    private boolean isBlankString(String string) {
        return string == null || string.trim().isEmpty();
    }

    /**
     * 문자열 배열에서 사칙연산에 쓰이는 값을 추출한다.
     *
     * @param values
     * @return
     */
    private List<Integer> getValues(String[] values) {
        List<Integer> result = new ArrayList<>();

        for (int index = 1; index < values.length; index = index + 2) {
            result.add(Integer.parseInt(values[index]));
        }

        return result;
    }

    /**
     * 문자열 배열에서 사칙연산으로 쓰이는 값을 추출한다.
     *
     * @param values
     * @return
     */
    private List<String> getOperations(String[] values) {
        List<String> result = new ArrayList<>();

        for (int index = 0; index < values.length; index = index + 2) {
            result.add(values[index]);
        }

        return result;
    }

    /***
     * 사용자가 입력한 문자열 값을 사칙연산을 수행하여 결과를 반환한다.
     * 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
     * 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
     * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
     * 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     * @param text
     * @return
     */
    public int compute(String text) {
        valid(text);

        AtomicInteger result = new AtomicInteger();
        String[] stringValues = text.trim().split(" ");

        result.set(Integer.parseInt(stringValues[0]));

        stringValues = Arrays.copyOfRange(stringValues, 1, stringValues.length);

        List<String> operations = getOperations(stringValues);
        List<Integer> values = getValues(stringValues);

        IntStream.range(0, values.size())
                .forEach(index -> result.set(Operator.toEnum(operations.get(index)).apply(result.get(), values.get(index))));

        return result.get();
    }
}
