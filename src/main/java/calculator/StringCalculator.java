package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringCalculator {

    private LinkedList<Number> numbers = new LinkedList<>();
    private LinkedList<Symbol> symbols = new LinkedList<>();

    /**
     * 문자열 사칙연산 계산
     * @param input 입력값
     * @return 계산결과
     */
    public int calculate(String input) {
        setElements(input);
        for (Symbol symbol : symbols) {
            Operator operator = Operator.findBySymbol(symbol.getItem());
            int calculated = operator.apply(
                Objects.requireNonNull(numbers.poll()).getItem(),
                Objects.requireNonNull(numbers.poll()).getItem()
            );
            numbers.offerFirst(new Number(calculated));
        }
        return Objects.requireNonNull(numbers.peek()).getItem();
    }

    /**
     * 입력값 셋팅
     * @param input 입력값
     */
    private void setElements(String input) {
        String[] elements = input.split("\\s+");
        numbers = Arrays.stream(elements)
                .filter(s -> s.matches("\\d+"))
                .map(Number::new)
                .collect(Collectors.toCollection(LinkedList::new));
        symbols = Arrays.stream(elements)
                .filter(s -> s.matches("\\D+"))
                .map(Symbol::new)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}