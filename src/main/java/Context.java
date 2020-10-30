public class Context {

    Integer result;
    String operator;

    public void take(Token token) {
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
    }
}
