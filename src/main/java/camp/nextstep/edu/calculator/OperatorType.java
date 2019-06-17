package camp.nextstep.edu.calculator;

import camp.nextstep.edu.util.AssertUtils;

import java.util.Arrays;

public enum OperatorType implements Operable<Integer> {
    ADDITION("+") {
        @Override
        public Integer operate(Integer source, Integer target) {
            AssertUtils.notNull(source, "'source' must not be null");
            AssertUtils.notNull(target, "'target' must not be null");
            return source + target;
        }
    },
    SUBTRACTION("-") {
        @Override
        public Integer operate(Integer source, Integer target) {
            AssertUtils.notNull(source, "'source' must not be null");
            AssertUtils.notNull(target, "'target' must not be null");
            return source - target;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public Integer operate(Integer source, Integer target) {
            AssertUtils.notNull(source, "'source' must not be null");
            AssertUtils.notNull(target, "'target' must not be null");
            return source * target;
        }
    },
    DIVISION("/") {
        @Override
        public Integer operate(Integer source, Integer target) {
            AssertUtils.notNull(source, "'source' must not be null");
            AssertUtils.notNull(target, "'target' must not be null");
            if (target.equals(ZERO)) {
                throw new ArithmeticException("Cannot divided by 0");
            }
            return source / target;
        }
    };

    private static final int ZERO = 0;
    private final String sign;

    OperatorType(String sign) {
        this.sign = sign;
    }

    public static OperatorType from(String value) {
        final OperatorType[] types = OperatorType.values();
        return Arrays.stream(types)
                .filter(type -> type.sign.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("'value' is not supported. value:" + value));
    }

    @Override
    public String toString() {
        return "OperatorType(name=" + this.name() + ", sign=" + this.sign + ")";
    }
}
