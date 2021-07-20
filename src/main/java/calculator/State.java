package calculator;

import java.util.Objects;

public class State {

    private final Formula.ConfigurationType type;
    private final int result;
    private final Operator operator;

    public State(Formula.ConfigurationType type, int result, Operator operator) {
        this.type = type;
        this.result = result;
        this.operator = operator;
    }

    public static State changeTypeAndResult(State prevState, Formula.ConfigurationType type, int result) {
        return new State(type, result, prevState.operator);
    }

    public static State changeTypeAndOperator(State prevState, Formula.ConfigurationType type, Operator operator) {
        return new State(type, prevState.result, operator);
    }

    public static State makeDefaultState() {
        return new State(Formula.ConfigurationType.NONE, 0, null);
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
        State state = (State) o;
        return result == state.result && type == state.type && operator == state.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, result, operator);
    }
}
