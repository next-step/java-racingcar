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

    public int separatingValueFromTheOperator(String input) {
        String[] splitFormula = calculator.getSplitFormula(input);

        int length = splitFormula.length;
        for (int i = 0; i < length; i++) {
            String value = splitFormula[i];

            if (calculator.isNumber(value)){
                intValues.add(Integer.valueOf(value));
                continue;
            }
            operators.add(value);
        }


        return 0;
    }

    public LinkedList<Integer> getIntValues() {
        return intValues;
    }

    public LinkedList<String> getOperators() {
        return operators;
    }
}
