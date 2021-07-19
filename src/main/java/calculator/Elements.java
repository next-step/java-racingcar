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

        for (int i = 1; i < elements.length; i = i + 2)
            result = calculateOneCycle(result, elements[i], elements[i + 1]);

        return result;
    }

    private int calculateOneCycle(int number1, String operator, String number2) {
        if (operator.equals("+"))
            return number1 + Integer.parseInt(number2);
        if (operator.equals("-"))
            return number1 - Integer.parseInt(number2);
        if (operator.equals("*"))
            return number1 * Integer.parseInt(number2);
        if (operator.equals("/"))
            return number1 / Integer.parseInt(number2);
        throw new IllegalArgumentException("짝수번째 문자는 사칙 연산자만 올 수 있습니다.");
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
