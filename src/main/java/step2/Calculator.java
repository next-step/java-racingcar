package step2;

public class Calculator {

    private ExpressionManager expressionManager = null;
<<<<<<< HEAD
    private static final String splitToken = " ";
=======
    private final static String splitToken = " ";
>>>>>>> refactor - [step2] 상수 멤버 변수를 static 으로 선언해서 인스턴스 생성 할때마다 메모리를 재할당 하지않고 재사용할수있게 한다.

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
