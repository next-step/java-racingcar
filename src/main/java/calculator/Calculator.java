package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern regExp = Pattern.compile("^[0-9]*$");
    private final Formula formula;

    public Calculator(Formula formula) {
        this.formula = formula;
    }

    public int calculate() {
        return calculateState(CalculatorState.makeDefaultState()).getResult();
    }

    private CalculatorState calculateState(CalculatorState calculatorState) {
        for (String input : formula.getFormula()) {
            calculatorState = makeCalculatorState(calculatorState, input, getFormulaConfigurationType(input));
        }

        return calculatorState;
    }

    private CalculatorState makeCalculatorState(CalculatorState state, String input, Formula.ConfigurationType currentType) {
        if (isNotValidCalculateSequence(state, currentType)) {
            throw new IllegalArgumentException();
        }

        if (isNumber(input)) {
            return CalculatorState.changeTypeAndResult(state, currentType, operate(state, input));
        }

        return CalculatorState.changeTypeAndOperator(state, currentType, Operator.findOperator(input));
    }

    private int operate(CalculatorState state, String input) {
        Operator operator = state.getOperator();

        if (operator != null) {
            return operator.operate(state.getResult(), Integer.parseInt(input));
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

    private boolean isNotValidCalculateSequence(CalculatorState state, Formula.ConfigurationType currentType) {
        return !Formula.ConfigurationType.isValidCalculatorSequence(state.getType(), currentType);
    }

}
