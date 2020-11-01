package step2;

public class Calculator {

    private ExpressionManager expressionManager = null;
    private final static String splitToken = " ";

    public Calculator(String expression) {
        this.read(expression);
    }

    private void read(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_EXPRESSION);
        }
        String[] split = expression.split(splitToken);

        if (split.length % 2 == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_EXPRESSION);
        }
        expressionManager = new ExpressionManager(split);
    }

    public int calc() {
        while (expressionManager.hasNext()) {
            SingleExpression nextSingleExpression = expressionManager.getNextSingleExpression();
            int calcResult = nextSingleExpression.operate();
            expressionManager.addCalcResult(calcResult);
        }
        return expressionManager.getResult();
    }

}
