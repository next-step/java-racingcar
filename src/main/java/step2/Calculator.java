package step2;

public class Calculator {

    private ExpressionManager expressionManager = null;
    private final SingleExpressionCalculator singleExpressionCalculator = new SingleExpressionCalculator();
    private final String splitToken = " ";

    public Calculator(String expression) {
        this.read(expression);
    }

    private void read(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        expressionManager = new ExpressionManager(expression.split(splitToken));
    }

    public int calc() {
        if (expressionManager.hasNext()) {
            SingleExpression nextSingleExpression = expressionManager.getNextSingleExpression();
            int calcResult = singleExpressionCalculator.calc(nextSingleExpression);
            expressionManager.addCalcResult(calcResult);
        }
        return expressionManager.getResult();
    }

}
