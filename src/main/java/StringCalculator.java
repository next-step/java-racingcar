import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.BinaryOperator;

import static java.lang.Double.valueOf;


class StringCalculator {
    private String[] values;

    private LinkedList<Double> operands;
    private LinkedList<String> operators;

    private double result;

    public StringCalculator() {
        this(new LinkedList<>(), new LinkedList<>());
    }

    private StringCalculator(LinkedList<Double> operands, LinkedList<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public double getResult() {
        return result;
    }

    public void calculate() {
        result = operands.poll();
        while(operands.size() != 0) {
            Operator operator = Operator.of(operators.poll());
            result = operator.calculate(result, operands.poll());
        }
    }

    public void enter(final String s) {
        values = s.split(" ");
        if(values.length < 3) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
        for(int i = 0; i < values.length; i++) {
            validate(i, values[i]);
            add(values[i]);
        }
    }

    private void validate(final int idx, final String value) {
        if(idx % 2 == 0 && !isNumeric(value)) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
        if(idx % 2 == 1 && isNumeric(value)) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
    }

    private void add(final String value) {
        if(isNumeric(value)) {
            operands.add(valueOf(value));
        }
        if(!isNumeric(value)) {
            operators.add(value);
        }
    }

    private static boolean isNumeric(final String s) {
        if("".equals(s)) {
            return false;
        }
        return s.matches("-?\\d+(\\.\\d+)?");
    }

    private enum Operator {
        PLUS("+", (e1, e2)->e1 + e2),
        MINUS("-", (e1, e2)->e1 - e2),
        DIVISION("/", (e1, e2)->e1 / e2),
        MULTI("*", (e1, e2)->e1 * e2);

        private String operator;
        private BinaryOperator<Double> operating;

        Operator(final String operator, final BinaryOperator<Double> operating) {
            this.operator = operator;
            this.operating = operating;
        }

        private static Operator of(final String operator) {
            return Arrays.stream(Operator.values())
                    .filter(value->value.operator.equals(operator))
                    .findFirst()
                    .orElseThrow(()->new IllegalArgumentException("연산자가 올바르지 않습니다."));
        }

        private Double calculate(final Double e1, final Double e2) {
            return operating.apply(e1, e2);
        }
    }

}