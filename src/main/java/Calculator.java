public class Calculator {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }

    public String[] checkMathExpression(String mathExpression) {

        if(mathExpression == null || mathExpression.equals("")) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }

        return mathExpression.split(" ");
    }
}
