package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racing.StringHelper.*;

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
            throwExceptionIfNullOrEmpty(input);
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
    private Integer result = 0;

    public int calculate(String input) {
        throwExceptionIfNullOrEmpty(input);

        this.split = Arrays.asList(input.split(" "));
        return calculation();
    }

    private void calculationWithOperator() {
        if (!shouldCalculation()) {
            return;
        }

        Integer a = this.numbers.get(0);
        Integer b = this.numbers.get(1);

        switch (this.operator) {

            case PLUS:
                this.result = Math.addExact(a, b);
                break;
            case MINUS:
                this.result = Math.subtractExact(a ,b);
                break;
            case MULTIPLICATION:
                this.result = Math.multiplyExact(a, b);
                break;
            case DIVISION:
                this.result = Math.floorDiv(a, b);
                break;
        }

        clear();
        this.numbers.add(this.result);
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

    private int calculation() {
        if (this.split == null || this.split.size() < 1) {
            throw new IllegalArgumentException();
        }

        this.result = 0;

        for (String s : this.split) {
            throwExceptionIfNullOrEmpty(s);
            setValues(this.split.indexOf(s), s);
            calculationWithOperator();
        }
        return this.result;
    }
}
