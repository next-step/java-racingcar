package step2.domain;

public class Calculator {

    private static final int FORMULA_MIN_LENGTH = 3;
    private String[] formulaElements;

    private Calculator() {
    }

    public static Calculator create() {
        return new Calculator();
    }

    public void input(String formula) {
        checkFormulaEmpty(formula);
        String[] splitFormula = getSplitFormula(formula);
        checkValidFormula(splitFormula);
        this.formulaElements = splitFormula;
    }

    public String getFormula() {
        return String.join(" ", formulaElements);
    }

    public int calculate() {
        checkFormulaElementsEmpty();
        int currentResult = parseStringToInt(formulaElements[0]);
        for (int idx = 1; idx < formulaElements.length; idx += 2) {
            String operator = formulaElements[idx];
            int nextNumber = parseStringToInt(formulaElements[idx+1]);
            currentResult = calculate(currentResult, operator, nextNumber);
        }
        return currentResult;
    }

    private int calculate(int operand1, String operator, int operand2) {
        isOperator(operator);
        if ("+".equals(operator)) return plus(operand1, operand2);
        if ("-".equals(operator)) return subtract(operand1, operand2);
        if ("*".equals(operator)) return multiply(operand1, operand2);
        if ("/".equals(operator)) return division(operand1, operand2);
        return 0;
    }

    public int plus(int operand1, int operand2) {
        return (operand1 + operand2);
    }

    public int subtract(int operand1, int operand2) {
        return (operand1 - operand2);
    }

    public int multiply(int operand1, int operand2) {
        return (operand1 * operand2);
    }

    public int division(int operand1, int operand2) {
        return (operand1 / operand2);
    }

    private void checkFormulaEmpty(String formula) {
        if (formula == null || "".equals(formula) || " ".equals(formula)) {
            throw new IllegalArgumentException("수식은 null 이나 빈 공백을 허용하지않습니다.");
        }
    }

    private void checkValidFormula(String[] splitFormula) {
        if (splitFormula.length < FORMULA_MIN_LENGTH) {
            throw new IllegalArgumentException("최소 1개 이상의 수식을 입력해야합니다.");
        }
    }

    private void checkFormulaElementsEmpty() {
        if (this.formulaElements == null || this.formulaElements.length == 0) {
            throw new IllegalArgumentException("수식을 입력해주세요.");
        }
    }

    private String[] getSplitFormula(String formula) {
        return formula.split(" ");
    }

    private int parseStringToInt(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어있습니다.");
        }
        return Integer.parseInt(number);
    }

    private boolean isNumeric(String element) {
        boolean result = true;
        for (char c : element.toCharArray()) {
            if (!Character.isDigit(c)) {
                result = false;
            }
        }
        return result;
    }

    private void isOperator(String element) {
        if ("+".equals(element)) return;
        if ("-".equals(element)) return;
        if ("*".equals(element)) return;
        if ("/".equals(element)) return;
        throw new IllegalArgumentException("허용되지 않은 문자입니다.");
    }
}
