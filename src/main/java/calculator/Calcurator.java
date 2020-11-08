package calculator;

public class Calcurator {
    private static final int initIndex = 0;
    int operatorIndex = 1;
    int secondValueIndex = 2;

    public int calcurateString(String expression) {
        isBlank(expression);
        String[] splitStr = expression.split(" ");
        int result = 0;
        result = toInt(splitStr[initIndex]);
        int expStrRange = 2;
        for (int i = 0; i < splitStr.length - expStrRange; i += expStrRange) {
            isBlank(splitStr[i + operatorIndex]);
            isBlank(splitStr[i + secondValueIndex]);
            char operator = checkOperator(splitStr[i + operatorIndex]);
            int secondValue = toInt(splitStr[i + secondValueIndex]);
            result = calcurate(result, operator, secondValue);
        }
        return result;
    }

    private int toInt(String str) {
        return Integer.parseInt(str.trim());
    }

    public void isBlank(String inputValue) {
        if (inputValue == null || inputValue == " ") {
            throw new IllegalArgumentException("값이 존재하지 않습니다.");
        }
    }

    public int calcurate(int firstValue, char operator, int secondValue) {
        return getResult(firstValue, operator, secondValue);
    }

    public char checkOperator(String operator) {
        char charOperator = operator.trim().charAt(0);
        boolean isIncludeOperator = false;
        for (Operator element : Operator.values()) {
            if (charOperator == element.getOperator()) {
                isIncludeOperator = true;
            }
        }
        if (isIncludeOperator == false) {
            throw new IllegalArgumentException(" 계산할 수 없는 연산자 입니다.");
        }
        return charOperator;
    }

    private int getResult(int firstValue, char operator, int secondValue) {

        int result = 0;
        if (operator == Operator.PLUS.getOperator()) {
            result = add(firstValue, secondValue);
        }
        if (operator == Operator.SUBSTRACT.getOperator()) {
            result = subtract(firstValue, secondValue);
        }
        if (operator == Operator.MULTIPLY.getOperator()) {
            result = multiply(firstValue, secondValue);
        }
        if (operator == Operator.DIVIDE.getOperator()) {
            if (secondValue == 0) {
                String exptionMsg = firstValue + "를 0으로 나눌 수는 없습니다.";
                throw new ArithmeticException(exptionMsg);
            }
            result = divide(firstValue, secondValue);
        }
        return result;
    }


    public int add(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

    public int subtract(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }

    public int multiply(int firstValue, int secondValue) {
        return firstValue * secondValue;
    }
    public int divide(int firstValue, int secondValue) {
        return firstValue / secondValue;
    }
}
