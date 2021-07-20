public class Calculator {

    public static final String plus = "+";
    public static final String minus = "-";
    public static final String multiple = "*";
    public static final String divide = "/";

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

    public void checkOperator(String operator) {

        if(!operator.equals(plus) && !operator.equals(minus)
            && !operator.equals(divide) && !operator.equals(multiple)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

    }

    public String executeCalculator(String operator, int num1, int num2) {

        if(operator.equals(plus)) {
            return String.valueOf(add(num1, num2));
        }
        else if(operator.equals(minus)) {
            return String.valueOf(minus(num1, num2));
        }
        else if(operator.equals(multiple)) {
            return String.valueOf(multiply(num1, num2));
        }
        else {
            return String.valueOf(divide(num1, num2));
        }

    }

}
