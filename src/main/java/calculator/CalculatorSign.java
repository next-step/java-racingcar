package calculator;

import java.util.Arrays;

public enum CalculatorSign implements Operator {
    ADDITION("+") {
        @Override
        public int operate(int a, int b) {
            return a+b;
        }
    },
    DIVISION("/") {
        @Override
        public int operate(int a, int b) {
            return a / b;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int operate(int a, int b) {
            return a * b;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    };

    private String codeName;

    CalculatorSign(String codeName) {
        this.codeName = codeName;
    }

    public static CalculatorSign findByCodeName(String sign) {
        return Arrays.stream(CalculatorSign.values())
                .filter(calculatorSign -> calculatorSign.getCodeName().equals(sign))
                .findFirst().get();
    }

    private String getCodeName() {
        return this.codeName;
    }
}
