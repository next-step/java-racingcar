package step2;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class StringCalculator {
    private static final String DELIMETER = " ";
    private static final String OPERATOR_PATTERN = "[+\\-*/]";
    private static final String NUMBER_PATTERN = "(^\\d*)$";
    private static final IntFunction<Boolean> isEven = (i)-> i % 2 == 0;
    private static final IntFunction<Boolean> isOdd = (i)-> i % 2 == 1;
    private final List<Integer> numbers = new ArrayList<>();
    private final Queue<String> operators = new LinkedList<>();

    public void filteringNumber(String[] strings){
        numbers.clear();
        IntStream.range(0, strings.length).forEach(index->{
            if (isEven.apply(index)) {
                isValid(strings[index]);
                numbers.add(Integer.parseInt(strings[index]));
            }
        });
    }
    public void filteringOperator(String[] strings){
        operators.clear();
        IntStream.range(0, strings.length).forEach(index->{
            if (isOdd.apply(index)) {
                isValid(strings[index]);
                operators.add(strings[index]);
            }
        });
    }

    /**
     * @implSpec
     * 인자값으로 문자열을 받아 DELEMITER기준으로 분할하여 문자열의 첫 번째 요소부터 순회하며 사칙연산을 수행하는 메소드
     */
    protected Integer calculate(String input) {
        isEmpty(input);
        String[] strings = input.split(DELIMETER);
        filteringNumber(strings);
        filteringOperator(strings);
        Optional<Integer> reduce = numbers.stream()
                .reduce((prev, after) -> Operator.execute(new ComputationalInformation(prev, after, operators.poll())));

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
