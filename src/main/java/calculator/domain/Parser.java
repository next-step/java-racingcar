package calculator.domain;

import calculator.domain.operator.Divide;
import calculator.domain.operator.Minus;
import calculator.domain.operator.Multiply;
import calculator.domain.operator.Operator;
import calculator.domain.operator.Operators;
import calculator.domain.operator.Plus;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Parser {

    private final Numbers numbers;
    private final Operators operators;
    private final String formula;
    private final Map<String, Operator> map;

    private List<String> parsedElements;

    public Parser(String formula) {
        this.formula = formula;
        this.numbers = new Numbers();
        this.operators = new Operators();
        this.map = new HashMap<>();
        initOperatorMap();

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

    private void initOperatorMap() {
        map.put("+", new Plus());
        map.put("-", new Minus());
        map.put("*", new Multiply());
        map.put("/", new Divide());
    }

    private void distribution() {
        int index;

        for (index = 0; index < parsedElements.size() - 2; index += 2) {
            numbers.add(new Number(parsedElements.get(index)));

            // TODO: 보류
            Operator operator = map.get(parsedElements.get(index + 1));
            if (operator == null) {
                throw new IllegalArgumentException("올바르지 않은 연산 기호입니다.");
            }
            operators.add(operator);
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
