package calc;


public class Calculation {
    public int calc(String formula) {
        String[] formulaArr = formula.split(" ");
        if (formula == null || formula.trim().equals("") || formulaArr.length == 0) {
            throw new IllegalArgumentException("formula is blank");
        }

        int result = 0;
        int i = 0;
        while (i < formulaArr.length) {
            if (i == 0) {
                result = Integer.parseInt(formulaArr[i++]);
            }
            String op = formulaArr[i++];
            int num = Integer.parseInt(formulaArr[i++]);
            result = calculate(result, num, op);
        }
        System.out.println("result : "+ result);
        return result;
    }

    public int calculate(int a, int b, String op) {
        if (op.equals("+")) {
            return add(a, b);
        }
        if (op.equals("-")) {
            return sub(a, b);
        }
        if (op.equals("*")) {
            return mul(a, b);
        }
        if (op.equals("/")) {
            return div(a, b);
        }
        throw new IllegalArgumentException("not support operation");
    }

    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    int div(int a, int b) {
        return a / b;
    }
}
