package calculator;

import java.util.Arrays;

public class Elements {

    private final String[] elements;

    public Elements(String[] elements) {
        this.elements = new String[elements.length];

        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            if (i % 2 == 0 && !isNumber(element))
                throw new IllegalArgumentException("홀수번째 문자는 숫자만 올 수 있습니다.");
            if (i % 2 == 1 && !isOperator(element))
                throw new IllegalArgumentException("짝수번째 문자는 사칙 연산자만 올 수 있습니다.");
            this.elements[i] = element;
        }
    }

    public int calculate() {

        int result = Integer.parseInt(elements[0]);

        for (int i = 1; i < elements.length; i = i + 2) {
            result = Operator.calculate(elements[i], result, Integer.parseInt(elements[i + 1]));
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
        return Arrays.equals(elements, elements1.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
}
