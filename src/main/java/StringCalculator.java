public class StringCalculator {
    public void isNotBlank (String blank) {
        if ("".equals(blank) || " ".equals(blank) || blank == null) {
            throw new IllegalArgumentException("연산자가 빈값 또는 null입니다.");
        }
    }

    public Double calculator (Double leftNumber, String operator, Double rightNumber) {
        return Operator.of(operator).calculator(leftNumber, rightNumber);
    }

    public String getOperator (String[] expressionArray, int index) {
        return expressionArray[index];
    }

    public String getRightNumber (String[] expressionArray, int index) {
        return expressionArray[index + 1];
    }

    public Double isDigit (String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return Double.valueOf(number);
    }
}
