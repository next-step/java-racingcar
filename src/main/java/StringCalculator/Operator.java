package StringCalculator;

import java.util.Arrays;

/**
 * 연산자
 */
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

    /**
     * 사칙 연산자인지 확인 후 값 저장
     * @param operator 연산자
     */
    public static Operator setOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(operator1 -> operator1.value.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Wrong operator type"));
    }
}
