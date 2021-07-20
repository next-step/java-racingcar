package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Elements {

    private final List<String> elements;

    public Elements(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자가 올 수 없습니다.");
        }
        this.elements = Arrays.asList(input.split(" "));
    }

    public int calculate() {
        int result = Integer.parseInt(elements.get(0));

        for (int i = 1; i < elements.size(); i = i + 2) {
            result = Operator.calculate(elements.get(i), result, Integer.parseInt(elements.get(i + 1)));
        }
        return result;
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
