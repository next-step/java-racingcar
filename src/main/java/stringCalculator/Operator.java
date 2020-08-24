package stringCalculator;

import java.util.Arrays;

public enum Operator {
    PLUS("+"){
        @Override
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    },
    MINUS("-"){
        @Override
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("*"){
        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/"){
        @Override
        public int calculate(int num1, int num2) {
            if(num2 == 0) {
                throw new IllegalArgumentException("Can not be divide by ZERO");
            }
            return num1 / num2;
        }
    };

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public abstract int calculate(int num1, int num2);

    public static Operator setOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(operator1 -> operator1.value.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Wrong operator type"));
    }
}
