public class Calculator {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLE = "*";
    public static final String DIVIDE = "/";

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

        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        }

        return num1 / num2;
    }

    public String execute(String mathExpression) throws IllegalArgumentException {

        String[] splitMath = checkMathExpression(mathExpression);

        for(int i = 0; i < splitMath.length-1; i = i+2) {
            int num1 = Integer.parseInt(splitMath[i]);
            int num2 = Integer.parseInt(splitMath[i+2]);
            String operator = splitMath[i+1];
            checkOperator(operator);
            splitMath[i+2] = executeCalculator(operator, num1, num2);
        }

        return splitMath[splitMath.length-1];

    }

    public String[] checkMathExpression(String mathExpression) {

        if (mathExpression == null || mathExpression.equals("")) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }

        return mathExpression.split(" ");
    }

    public void checkOperator(String operator) {

        if(!operator.equals(PLUS) && !operator.equals(MINUS)
            && !operator.equals(DIVIDE) && !operator.equals(MULTIPLE)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

    }

    public String executeCalculator(String operator, int num1, int num2) {

        if (operator.equals(PLUS)) {
            return String.valueOf(add(num1, num2));
        }
        if (operator.equals(MINUS)) {
            return String.valueOf(minus(num1, num2));
        }
        if (operator.equals(MULTIPLE)) {
            return String.valueOf(multiply(num1, num2));
        }

        return String.valueOf(divide(num1, num2));
    }
}
