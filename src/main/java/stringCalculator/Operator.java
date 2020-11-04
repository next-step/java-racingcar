package stringCalculator;

import stringCalculator.exception.OperatorException;

import java.util.ArrayList;
import java.util.List;

public class Operator {

    private final List<String> operators = new ArrayList<>();
    private final String[] values;

    public Operator(String[] values) {
        this.values = values;
        createOperator();
    }

    private void createOperator() {
        int length = values.length;
        for (int i = 1; i < length; i += 2) {
            validateOperator(values[i]);
            addOperator(values[i]);
        }
    }

    private void validateOperator(String value) {
        if (!("+".equals(value) || "-".equals(value) || "*".equals(value)|| "/".equals(value))) {
            throw new OperatorException();
        }
    }

    private void addOperator(String value) {
        operators.add(value);
    }

    public List<String> getOperators() {
        return operators;
    }
}
