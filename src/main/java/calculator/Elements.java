package calculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Elements {

    private final List<String> elements;

    public Elements(String[] elements) {
        this.elements = IntStream.range(0, elements.length)
                .filter(index -> valid(elements, index))
                .mapToObj((index) -> elements[index])
                .collect(Collectors.toList());
    }

    private boolean valid(String[] elements, int index) {
        if (index % 2 == 0 && !isNumber(elements[index]))
            throw new IllegalArgumentException("홀수번째 문자는 숫자만 올 수 있습니다.");
        if (index % 2 == 1 && !isOperator(elements[index]))
            throw new IllegalArgumentException("짝수번째 문자는 사칙 연산자만 올 수 있습니다.");
        return true;
    }

    public int calculate() {

        int result = Integer.parseInt(elements.get(0));

        for (int i = 1; i < elements.size(); i = i + 2) {
            result = Operator.calculate(elements.get(i), result, Integer.parseInt(elements.get(i + 1)));
        }
        return result;
    }

    boolean isNumber(String str) {
        return str.matches("^-?[0-9]+$");
    }

    boolean isOperator(String str) {
        return str.matches("^[\\-+*/]$");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Elements)) return false;
        Elements elements1 = (Elements) o;
        return Objects.equals(elements, elements1.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
