package stringCalculator;

import stringCalculator.exception.TypeException;

/**
 * 연산하는 클래스
 */
public enum Calculate implements Calculatable{
    ADD("+") {
        @Override
        public int calculate(int firstNumber, int secondNumber) {
            return firstNumber + secondNumber;
        }
    },

    SUBTRACT("-") {
        @Override
        public int calculate(int firstNumber, int secondNumber) {
            return firstNumber - secondNumber;
        }
    },

    MULTIPLE("*") {
        @Override
        public int calculate(int firstNumber, int secondNumber) {
            return firstNumber * secondNumber;
        }
    },

    DIVISION("/") {
        @Override
        public int calculate(int firstNumber, int secondNumber) {
            return firstNumber / secondNumber;
        }
    };

    private final String operator;

    Calculate(String operator) {
        this.operator = operator;
    }

    /**
     * 연산
     */
    public static int calculate(String operator, int firstNumber, int secondNumber) {
        try {
            return of(operator).calculate(firstNumber, secondNumber);
        } catch (NullPointerException e) {
            throw new TypeException();
        }
    }

    /**
     * enum 반환
     */
    private static Calculatable of(String operator) {
        Calculate[] values = Calculate.values();
        for (Calculate value : values) {
            if (value.operator.equals(operator)) {
                return value;
            }
        }
        return null;
    }
}
