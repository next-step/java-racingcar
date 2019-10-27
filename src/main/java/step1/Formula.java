package step1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public final class Formula<T> {
    private static final int MINIMUM_FORMULA_NODE_VALUE_SIZE = 1;

    private final Deque<FormulaNodeValue<T>> values;
    private final Deque<FormulaNodeOperator<T>> operators;

    Formula(final List<FormulaNodeValue<T>> values, final List<FormulaNodeOperator<T>> operators) {
        ensureFormulaFormat(values, operators);

        this.values = new LinkedList<>(values);
        this.operators = new LinkedList<>(operators);
    }

    private void ensureFormulaFormat(final List<FormulaNodeValue<T>> values,
                                     final List<FormulaNodeOperator<T>> operators) {
        if (values.isEmpty()) {
            throw new IllegalFormulaFormatException("formula must have one value at least");
        }
        if ((values.size() - MINIMUM_FORMULA_NODE_VALUE_SIZE) != operators.size()) {
            throw new IllegalFormulaFormatException(String.format(
                    "value and operator size are not matched: value:[%s], operators:[%s]",
                    values.size(), operators.size()));
        }
    }

    public FormulaNodeValue<T> evaluate() {
        if (isOperatorsEmpty()) {
            return getEvaluateResult();
        }
        return evaluateInternal();
    }

    private boolean isOperatorsEmpty() {
        return operators.size() == 0;
    }

    private FormulaNodeValue<T> evaluateInternal() {
        while (values.size() != MINIMUM_FORMULA_NODE_VALUE_SIZE) {
            final FormulaNodeValue<T> leftOperand = values.removeFirst();
            final FormulaNodeValue<T> rightOperand = values.removeFirst();
            final FormulaNodeOperator<T> operator = operators.removeFirst();

            final FormulaNodeValue<T> next = operator.operate(leftOperand, rightOperand);
            values.addFirst(next);
        }

        return getEvaluateResult();
    }

    private FormulaNodeValue<T> getEvaluateResult() {
        if (values.size() != MINIMUM_FORMULA_NODE_VALUE_SIZE) {
            throw new IllegalFormulaStateException(String.format(
                    "something was broken after evaluation. values:[%s], operators:[%s]",
                    values.size(), operators.size()));
        }
        return values.peek();
    }
}
