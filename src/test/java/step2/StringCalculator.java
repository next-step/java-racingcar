package step2;


import java.util.*;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class StringCalculator {
    private static final String DELIMETER = " ";
    private static final String OPERATOR_PATTERN = "[+\\-*/]";
    private static final String NUMBER_PATTERN = "(^\\d*)$";
    private static final Map<String, IntBinaryOperator> functionByOperator = new HashMap<String, IntBinaryOperator>() {{

        put("+", Integer::sum);
        put("-", (i, j) -> i - j);
        put("*", (i, j) -> i * j);
        put("/", (i, j) -> i / j);
    }};

    private static final Function<Integer, Boolean> isEven = (i)-> i % 2 == 0;
    private static final Function<Integer, Boolean> isOdd = (i)-> i % 2 == 1;



    /**
     * @ImplSpec
     * 인자값으로 문자열을 받아 DELEMITER기준으로 분할하여 문자열의 첫 번째 요소부터 순회하며 사칙연산을 수행하는 메소드
     */
    protected Integer calculate(String input) {
        isEmpty(input);

        List<Integer> numbers = new ArrayList<>();
        Queue<String> operators = new LinkedList<>();
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String currentValue = strings[i];
            isValid(currentValue);
            if(isEven.apply(i))
                    numbers.add(Integer.parseInt(currentValue));
            if(isOdd.apply(i))
                    operators.offer(currentValue);
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
