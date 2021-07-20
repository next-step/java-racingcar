package calculator;

public class State {

    private final Formula.ConfigurationType type;
    private final int result;
    private final Operator operator;

    public State(Formula.ConfigurationType type, int result, Operator operator) {
        this.type = type;
        this.result = result;
        this.operator = operator;
    }

    public static State ofResult(State prevState, Formula.ConfigurationType type, int result) {
        return new State(type, result, prevState.operator);
    }

    public static State ofOperator(State prevState, Formula.ConfigurationType type, Operator operator) {
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

}
