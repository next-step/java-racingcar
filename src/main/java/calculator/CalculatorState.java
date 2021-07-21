package calculator;

import java.util.Objects;

public class CalculatorState {

    private final Formula.ConfigurationType type;
    private final int result;
    private final Operator operator;

    public CalculatorState(Formula.ConfigurationType type, int result, Operator operator) {
        this.type = type;
        this.result = result;
        this.operator = operator;
    }

    public static CalculatorState changeTypeAndResult(CalculatorState prevState, Formula.ConfigurationType type, int result) {
        return new CalculatorState(type, result, prevState.operator);
    }

    public static CalculatorState changeTypeAndOperator(CalculatorState prevState, Formula.ConfigurationType type, Operator operator) {
        return new CalculatorState(type, prevState.result, operator);
    }

    public static CalculatorState makeDefaultState() {
        return new CalculatorState(Formula.ConfigurationType.NONE, 0, null);
    }

    public Formula.ConfigurationType getType() {
        return type;
    }

    public int getResult() {
        return result;
    }

    public Operator getOperator() {
        return operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorState state = (CalculatorState) o;
        return result == state.result && type == state.type && operator == state.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, result, operator);
    }
}
