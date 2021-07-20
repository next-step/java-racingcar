package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern regExp = Pattern.compile("^[0-9]*$");
    private final Formula formula;

    public Calculator(Formula formula) {
        this.formula = formula;
    }

    public int calculate() {
        return calculateState(State.makeDefaultState()).getResult();
    }

    private State calculateState(State calcualtorState) {
        for (String input : formula.getFormula()) {
            Formula.ConfigurationType currentType = getFormulaConfigurationType(input);

            if (isNotValidCalculateSequence(calcualtorState, currentType)) {
                throw new IllegalArgumentException();
            }

            calcualtorState = makeCalculatorState(calcualtorState, input, currentType);
        }
        return calcualtorState;
    }

    private State makeCalculatorState(State prevState, String input, Formula.ConfigurationType currentType) {
        if (isNumber(input)) {
            return State.ofResult(prevState, currentType, operate(prevState, input));
        }

        return State.ofOperator(prevState, currentType, Operator.findOperator(input));
    }

    private int operate(State prevState, String input) {
        Operator operator = prevState.getOperator();

        if (operator != null) {
            return operator.operate(prevState.getResult(), Integer.parseInt(input));
        }

        return Integer.parseInt(input);
    }

    private Formula.ConfigurationType getFormulaConfigurationType(String input) {
        if (isNumber(input)) {
            return Formula.ConfigurationType.NUMBER;
        }

        return Formula.ConfigurationType.OPERATOR;
    }

    private boolean isNumber(String input) {
        return regExp.matcher(input).find();
    }

    private boolean isNotValidCalculateSequence(State state, Formula.ConfigurationType currentType) {
        return !Formula.ConfigurationType.isValidCalculatorSequence(state.getType(), currentType);
    }

}
