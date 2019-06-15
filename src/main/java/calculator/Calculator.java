package calculator;

public class Calculator {
    public static double add(double source, double inputNumber) {
        return source + inputNumber;
    }

    public static double subtract(double source, double inputNumber) {
        return source - inputNumber;
    }

    public static double multiply(double source, double inputNumber) {
        return source * inputNumber;
    }

    public static double divide(double source, double inputNumber) {
        if (inputNumber == 0) {
            throw new IllegalArgumentException("divide method's inputNumber argument must not be 0");
        }

        return source / inputNumber;
    }

    public static double calculateByOperator(double source, double inputNumber, SymbolType operator) {
        switch (operator) {
            case ADD: {
                return Calculator.add(source, inputNumber);
            }
            case SUBTRACT: {
                return Calculator.subtract(source, inputNumber);
            }
            case MULTIPLY: {
                return Calculator.multiply(source, inputNumber);
            }
            case DIVIDE: {
                return Calculator.divide(source, inputNumber);
            }
        }
        throw new IllegalArgumentException("Unexpected operator. Operator: " + operator);
    }
}
