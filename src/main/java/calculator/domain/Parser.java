package calculator.domain;

 import calculator.domain.operator.Operators;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {

    private final Numbers numbers;
    private final Operators operators;
    private final String formula;

    private List<String> parsedElements;

    public Parser(String formula) {
        this.formula = formula;
        this.numbers = new Numbers();
        this.operators = new Operators();

        validateFormula();
        parseFormula();
        distribution();
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public Operators getOperators() {
        return operators;
    }

    private void distribution() {
        int index;
        int ITERATION_UNIT = 2;
        int ITERATION_UNIT_LIMIT = parsedElements.size() - 2;

        for (index = 0; index < ITERATION_UNIT_LIMIT; index += ITERATION_UNIT) {
            numbers.add(new Number(parsedElements.get(index)));
            operators.add(operators.map().get(parsedElements.get(index + 1)));
        }
        numbers.add(new Number(parsedElements.get(index)));
    }

    private void parseFormula() {
        parsedElements = Arrays.asList(formula.split(" "));
    }

    private void validateFormula() {
        validateFormulaIsNull();
        validateFormulaIsEmpty();
        validateFormulaOperator();
        validateFormulaHasOneBlank();
    }

    private void validateFormulaIsEmpty() {
        if ("".equals(formula.trim())) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }
    }

    private void validateFormulaIsNull() {
        if (formula == null) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }
    }

    private void validateFormulaOperator() {
        boolean matches = Pattern.matches("^[0-9+\\-*/ ]*$", formula);
        if (!matches) {
            throw new IllegalArgumentException("숫자 및 사칙연산자, 공백 기호 이외에는 입력할 수 없습니다.");
        }
    }

    private void validateFormulaHasOneBlank() {
        if (formula.contains("  ")) {
            throw new IllegalArgumentException("공백이 두 자 이상일 수 없습니다.");
        }
    }

}
