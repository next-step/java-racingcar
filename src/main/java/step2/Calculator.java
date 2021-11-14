package step2;

public class Calculator {

    private final String expr;

    Calculator(String expr) {
        this.expr = expr;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
       return a / b;
    }

    public int calc(String expr) {
        if (expr == null || expr.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] exprArr = expr.split(" ");

        int result = Integer.parseInt(exprArr[0]);
        for (int i = 1; i < exprArr.length; i += 2) {
            String oper = exprArr[i];
            int op = Integer.parseInt(exprArr[i + 1]);

            switch (oper) {
                case "+": result += op;
                    break;
                case "-": result -= op;
                    break;
                case "*" : result *= op;
                    break;
                case "/" : result /= op;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        return result;
    }

    public int calcExpr() {
        return calc(expr);
    }
}
