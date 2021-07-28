package step2;

import java.util.Arrays;

public class OperatorUtil {

    public enum Operator {
        SUM("+"), SUB("-"), MUL("*"), DIV("/");
        private final String value;

        Operator(String value) {
            this.value = value;
        }

        public int operate(int first, int second) {
            if (this == SUM) {
                return sum(first, second);
            } else if (this == SUB) {
                return sub(first, second);
            } else if (this == MUL) {
                return mul(first, second);
            }
            return div(first, second);
        }

        private int sum(int first, int second) {
            return first + second;
        }

        private int sub(int first, int second) {
            return first - second;
        }

        private int mul(int first, int second) {
            return first * second;
        }

        private int div(int first, int second) {
            return first / second;
        }
    }

    public static int operate(String operator, int first, int second) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.value.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported Operation : " + operator))
                .operate(first, second);
    }
}
