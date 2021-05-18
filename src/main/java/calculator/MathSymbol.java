package calculator;

import java.util.Arrays;

public enum MathSymbol {
    PLUS("+") {
        @Override
        double operate(double firstNumber, double secondNumber) {
            return firstNumber + secondNumber;
        }
    },
    MINUS("-") {
        @Override
        double operate(double firstNumber, double secondNumber) {
            return firstNumber - secondNumber;
        }
    },
    DIVIDE("/") {
        @Override
        double operate(double firstNumber, double secondNumber) {
            return firstNumber / secondNumber;
        }
    },
    MULTIPLE("*") {
        @Override
        double operate(double firstNumber, double secondNumber) {
            return firstNumber * secondNumber;
        }
    };

    private final String mathSymbol;

    MathSymbol(String mathSymbol) {
        this.mathSymbol = mathSymbol;
    }

    public String getMathSymbol() {
        return mathSymbol;
    }

    public static MathSymbol findValidatedSymbol(String operator) {
        return Arrays.stream(MathSymbol.values())
                .filter(mathSymbol -> mathSymbol.mathSymbol.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입니다."));
    }

    abstract double operate(double firstNumber, double secondNumber);
}
