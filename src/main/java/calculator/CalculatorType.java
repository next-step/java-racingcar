package calculator;

public enum CalculatorType {

    ADD {
        int calculate(int value, int value2) { return value + value2; }
    },
    SUBTRACT {
        int calculate(int value, int value2) {
            return value - value2;
        }
    },
    MULTIPLY {
        int calculate(int value, int value2) { return value * value2; }
    },
    DIVIDE {
        int calculate(int value, int value2) {
            return value / value2;
        }
    };

    static CalculatorType calculatorType(String operator) {
        switch (operator) {
            case "+":
                return CalculatorType.ADD;
            case "-":
                return CalculatorType.SUBTRACT;
            case "*":
                return CalculatorType.MULTIPLY;
            case "/":
                return CalculatorType.DIVIDE;
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    abstract int calculate(int value, int value2);

}
