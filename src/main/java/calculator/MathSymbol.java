package calculator;

public enum MathSymbol {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLE("*");

    private final String mathSymbol;

    MathSymbol(String mathSymbol) {
        this.mathSymbol = mathSymbol;
    }

    public String getMathSymbol() {
        return mathSymbol;
    }

    public boolean isSame(String operator) {
        if (operator.equals(getMathSymbol())) {
            return true;
        }
        return false;
    }
}
