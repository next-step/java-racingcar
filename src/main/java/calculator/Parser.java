package calculator;

import calculator.domain.Operator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private final Validator validator;
    private final String formula;

    private final List<Integer> numbers;
    private final List<Operator> operators;

    private List<String> parsedElements;

    public Parser(String formula) {
        this.validator = Validator.getInstance(formula);
        this.formula = formula;

        this.numbers = new ArrayList<>();
        this.operators = new ArrayList<>();

        validateFormula();
        parseFormula();
        validateOrder();
        distribution();
    }

    private void distribution() {
        int index;

        for (index = 0; index < parsedElements.size() - 2; index += 2) {
            numbers.add(new Integer(parsedElements.get(index)));
            operators.add(new Operator(parsedElements.get(index + 1)));
        }
        numbers.add(new Integer(parsedElements.get(index)));
    }

    private void validateFormula() {
        validator.validateFormulaIsNull();
        validator.validateFormulaIsEmpty();
        validator.validateFormulaOperator();
        validator.validateFormulaHasOneBlank();
    }

    private void validateOrder() {
        validator.validateOrder(parsedElements);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    private void parseFormula() {
        parsedElements = Arrays.asList(formula.split(" "));
    }

}
