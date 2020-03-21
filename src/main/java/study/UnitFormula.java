package study;

public class UnitFormula {

    public static final String MSG_EMPTY_FORMULA = "Formula is null or empty.";
    public static final String MSG_INVALID_FORMULA = "Formula is invalid.";
    public static final String MSG_INVALID_NUMERIC = "This position should be numeric.";
    public static final String MSG_INVALID_OPERATOR = "This position should be an operator.";

    private Float left = null, right = null;
    private String operator;

    /*
        constructor
     */
    // ex. 3
    public UnitFormula(String monomial) {
        this.left = strToFloat(monomial);
    }

    public UnitFormula(float left, String operator, String right) {
        this.left = left;
        this.operator = operator;
        this.right = strToFloat(right);
    }

    private float strToFloat(String input) {
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(UnitFormula.MSG_INVALID_NUMERIC + "(value : " + input + ")");
        }
    }

    float getResult() {

        // check (left == null) -> throws in constructor
        // monomial case (only exist left term)
        if ( right == null ) {
            return left;
        }

        return calc();
    }

    private float calc() {
        switch (operator) {
            case "+":
                return add(left, right);
            case "-":
                return sub(left, right);
            case "*":
                return multi(left, right);
            case "/":
                return div(left, right);
            default:
                throw new IllegalArgumentException(MSG_INVALID_OPERATOR + "(value : " + operator + ")");
        }
    }

    private float add(float left, float right) {
        return left + right;
    }
    private float sub(float left, float right) {
        return left - right;
    }
    private float multi(float left, float right) {
        return left * right;
    }
    private float div(float left, float right) {
        return left / right;
    }
}
