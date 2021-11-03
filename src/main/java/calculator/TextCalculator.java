package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author han
 */
public class TextCalculator {

    enum Operator {
        PLUS("+"),
        MINUS("-"),
        MULTIPLICATION("*"),
        DIVISION("/");

        private String text;

        Operator(String text) {
            this.text = text;
        }

        public static Operator getInstance(String input) {
            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException();
            }

            Operator[] values = Operator.values();

            for (Operator o : values) {
                if (o.text.equals(input)) {
                    return o;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> numbers = new ArrayList<>();
    private Operator operator;
    private int size;

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] strings = input.split(" ");
        this.size = strings.length;

        int result = 0;
        for (int i = 0; i < size; i++) {
            String s = strings[i];

            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException();
            }

            if (i % 2 == 0) {
                this.numbers.add(Integer.parseInt(strings[i]));
            } else {
                this.operator = Operator.getInstance(strings[i]);
            }

            if (shouldAccumulate(this.numbers, this.operator)) {
                result = calculation(this.numbers, this.operator);
                this.numbers.clear();
                this.numbers.add(result);
                this.operator = null;
            }
        }
        return result;
    }

    private Integer calculation(List<Integer> numbers, Operator operator) {
        if (numbers == null || numbers.size() != 2 || operator == null) {
            throw new IllegalArgumentException();
        }

        Integer result = null;
        Integer a = numbers.get(0);
        Integer b = numbers.get(1);

        switch (operator) {

            case PLUS:
                result = Math.addExact(a, b);
                break;
            case MINUS:
                result = Math.subtractExact(a ,b);
                break;
            case MULTIPLICATION:
                result = Math.multiplyExact(a, b);
                break;
            case DIVISION:
                result = Math.floorDiv(a, b);
                break;
        }

        return result;
    }

    private boolean shouldAccumulate(List<Integer> numbers, Operator operator) {
        if (numbers == null || numbers.isEmpty() || operator == null) {
            return false;
        }
        return numbers.size() == 2 && operator != null;
    }
}
