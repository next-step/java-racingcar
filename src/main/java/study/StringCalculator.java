package study;

import java.util.LinkedList;

public class StringCalculator {
    private Calculator calculator;
    private LinkedList<Integer> intValues;
    private LinkedList<String> operators;

    public StringCalculator() {
        calculator = new Calculator();
        intValues = new LinkedList<>();
        operators = new LinkedList<>();
    }

    public void separatingValueFromTheOperator(String input) {
        String[] splitFormula = calculator.getSplitFormula(input);

        for (String value : splitFormula) {
            if (calculator.isNumber(value)) {
                intValues.add(Integer.valueOf(value));
                continue;
            }

            operators.add(calculator.checkPolicyOperator(value));
        }

    }

    public LinkedList<Integer> getIntValues() {
        return intValues;
    }

    public LinkedList<String> getOperators() {
        return operators;
    }

    public int computationLoof(LinkedList<Integer> intValues, LinkedList<String> operators) {
        for (String operator : operators) {
            int num1 = intValues.pollFirst();
            int num2 = intValues.poll();
            int result = calculator.computation(num1, num2, operator);
            intValues.addFirst(result);
        }

        return intValues.getFirst();
    }

    public int execute(String input) {
        this.nullAndEmptyValue(input);
        this.separatingValueFromTheOperator(input);
        return this.computationLoof(this.getIntValues(), this.getOperators());
    }

    public void nullAndEmptyValue(String number) {
        if (number == null || number.equals("")) {
            throw new IllegalArgumentException();
        }
    }
}
