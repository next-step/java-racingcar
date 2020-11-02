package step2;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

public class StringCalculator {
    private static final String DELIMETER = " ";
    private static final String OPERATOR_PATTERN = "[+\\-*/]";
    private static final String NUMBER_PATTERN = "(^\\d*)$";
    private static final Map<String, IntBinaryOperator> functionByOperator = new HashMap<>() {{
        put("+", Integer::sum);
        put("-", (i, j) -> i - j);
        put("*", (i, j) -> i * j);
        put("/", (i, j) -> i / j);
    }};
    private static final IntFunction<Boolean> isEven = (i)-> i % 2 == 0;
    private static final IntFunction<Boolean> isOdd = (i)-> i % 2 == 1;
    private final List<Integer> numbers = new ArrayList<>();
    private final Queue<String> operators = new LinkedList<>();

    public void filtering(int index, String value){
        numbers.clear();
        operators.clear();
        Boolean even = isEven.apply(index);
        if(even){
            numbers.add(Integer.parseInt(value));
        }
        if (!even) {
            operators.offer(value);
        }
    }

    /**
     * @implSpec
     * 인자값으로 문자열을 받아 DELEMITER기준으로 분할하여 문자열의 첫 번째 요소부터 순회하며 사칙연산을 수행하는 메소드
     */
    protected Integer calculate(String input) {
        isEmpty(input);
        String[] strings = input.split(DELIMETER);
        for (int i = 0; i < strings.length; i++) {
            String currentValue = strings[i];
            isValid(currentValue);
            filtering(i, currentValue);
        }
        Optional<Integer> reduce = numbers.stream()
                .reduce((prev, after) -> functionByOperator.get(operators.poll()).applyAsInt(prev, after));

        return reduce.orElseThrow(IllegalArgumentException::new);
    }

    private boolean isOperator(String input) {
        return input.matches(OPERATOR_PATTERN);
    }

    private boolean isNumber(String input) {
        return input.matches(NUMBER_PATTERN);
    }

    private void isEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty())
            throw new IllegalArgumentException("입력 값은 null이거나 빈 공백문자여서는 안됩니다.");
    }

    private void isValid(String input) {
        isEmpty(input);
        if (!isOperator(input) && !isNumber(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

}
