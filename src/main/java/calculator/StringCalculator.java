package calculator;

import java.util.LinkedList;
import type.MessageFactory;

class StringCalculator {
    private final CalculationElement<Double> operands;
    private final CalculationElement<String> operators;

    public static StringCalculator create() {
        return new StringCalculator();
    }

    private StringCalculator() {
        this(CalculationElement.from(new LinkedList<>()),
                CalculationElement.from(new LinkedList<>()));
    }

    private StringCalculator(CalculationElement<Double> operands, CalculationElement<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public StringCalculator enter(final String s) {
        String[] values = s.split(" ");
        if (values.length < 3) {
            throw new IllegalArgumentException(MessageFactory.getInputErrorMessage());
        }
        for (int i = 0; i < values.length; i++) {
            validate(i, values[i]);
            putIntoStack(values[i]);
        }
        return this;
    }

    private void validate(final int index, final String value) {
        if (isEvenNumber(index) && !isNumeric(value)) {
            throw new IllegalArgumentException(MessageFactory.getInputErrorMessage());
        }
        if (!isEvenNumber(index) && isNumeric(value)) {
            throw new IllegalArgumentException(MessageFactory.getInputErrorMessage());
        }
    }

    private boolean isEvenNumber(final int index) {
        return index % 2 == 0;
    }

    private boolean isNumeric(final String value) {
        return value.matches("[0-9]");
    }

    private void putIntoStack(final String value) {
        if (isNumeric(value)) {
            Double number = Double.valueOf(value);
            this.operands.add(number);
        }
        if (!isNumeric(value)) {
            this.operators.add(value);
        }
    }

    public void calculate() {
        double e1 = this.operands.poll();
        while (this.operands.size() != 0) {
            ArithmeticCalculator operator = ArithmeticCalculator.from(this.operators.poll());
            double e2 = this.operands.poll();
            e1 = operator.operation(e1, e2);
        }
        double result = e1;
        System.out.print("계산결과 : " + result);
    }
}
