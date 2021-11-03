package calculator;

import java.util.ArrayList;
import java.util.Arrays;
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

    private List<String> split;
    private List<Integer> numbers = new ArrayList<>();
    private Operator operator;

    public int calculate(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException();
        }

        this.split = Arrays.asList(input.split(" "));
        int result = 0;

        for (String s : this.split) {
            if (isNullOrEmpty(s)) {
                throw new IllegalArgumentException();
            }

            setValues(this.split.indexOf(s), s);

            if (shouldCalculation()) {
                result = calculation();
                clear();
                this.numbers.add(result);
            }
        }
        return result;
    }

    private Integer calculation() {
        if (this.numbers == null || this.numbers.size() != 2 || this.operator == null) {
            throw new IllegalArgumentException();
        }

        Integer result = null;
        Integer a = this.numbers.get(0);
        Integer b = this.numbers.get(1);

        switch (this.operator) {

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

    private boolean shouldCalculation() {
        if (this.numbers == null || this.numbers.isEmpty() || this.operator == null) {
            return false;
        }
        return this.numbers.size() == 2 && this.operator != null;
    }

    private void clear() {
        if (this.numbers == null && this.operator == null) {
            return;
        }
        this.numbers.clear();
        this.operator = null;
    }

    private void setValues(int index, String input) {
        if (index % 2 == 0) {
            this.numbers.add(Integer.parseInt(input));
            return;
        }
        this.operator = Operator.getInstance(input);
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
