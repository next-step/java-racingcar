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
            throw new IllegalArgumentException("수식이 유효하지 않음 - null or empty");
        }
        String[] split = expression.split(splitToken);

        if (split.length % 2 == 0) {
            throw new IllegalArgumentException("수식이 유효하지 않음");
        }
        expressionManager = new ExpressionManager(split);
    }

    public int calc() {
        while (expressionManager.hasNext()) {
            SingleExpression nextSingleExpression = expressionManager.getNextSingleExpression();
            int calcResult = singleExpressionCalculator.calc(nextSingleExpression);
            expressionManager.addCalcResult(calcResult);
        }
        return expressionManager.getResult();
    }

}
