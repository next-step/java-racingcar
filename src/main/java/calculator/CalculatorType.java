package calculator;

public enum CalculatorType {

    ADDITION {
        int calculate(int value, int value2) { return value + value2; }
    },
    SUBSTRACTION {
        int calculate(int value, int value2) {
            return value - value2;
        }
    },
    MULTIPLICATION {
        int calculate(int value, int value2) { return value * value2; }
    },
    DIVISION {
        int calculate(int value, int value2) {
            return value / value2;
        }
    };


    abstract int calculate(int value, int value2);

}
