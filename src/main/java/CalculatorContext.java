public class CalculatorContext {

    private Integer result;
    private String operator;

    public void takeNextToken(Token token) {
        if (hasNoInitialNumber()) {
            result = token.getNumber();
            return;
        }
        if (token.isOperator()) {
            operator = token.getOperator();
            return;
        }
        if (token.isNumber()) {
            runOperation(token.getNumber());
            return;
        }
    }

    public int getResult() {
        return result;
    }

    private boolean hasNoInitialNumber() {
        return result == null;
    }

    private void runOperation(int number) {
        if ("+".equals(operator)) {
            result = result + number;
        }
        if ("-".equals(operator)) {
            result = result - number;
        }
        if ("*".equals(operator)) {
            result = result * number;
        }
        if ("/".equals(operator)) {
            result = result / number;
        }
    }
}
