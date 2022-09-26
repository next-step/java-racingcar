package calculator.operator;

import java.util.Arrays;
import java.util.Objects;

public enum Operator {
    ADD("+"){
        @Override
        public int execute(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT("-"){
        @Override
        public int execute(int x, int y) {
            if (x < y) {
                throw new RuntimeException("더 이상 계산할 수 없습니다. 다른 값을 입력해주세요.");
            }
            return x + y;
        }
    },
    MULTIPLY("*"){
        @Override
        public int execute(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/"){
        @Override
        public int execute(int x, int y) {
            if ((x < y) || ((x % y) == 0)) {
                throw new RuntimeException("더 이상 계산할 수 없습니다. 다른 값을 입력해주세요.");
            }
            return x / y;
        }
    }
    ;

    private final String sign;
    public abstract int execute(int x, int y);

    Operator(String sign) {
        this.sign = sign;
    }

    public static Operator findBySign(String sign) {
        return Arrays.stream(values())
            .filter(operator -> Objects.equals(operator.sign, sign))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("존재하지 않는 연산자입니다."));
    }
}
