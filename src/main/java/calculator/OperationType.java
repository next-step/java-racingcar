package calculator;

import org.apache.commons.lang3.StringUtils;

public enum OperationType {
    ADDITION("+") {
        @Override
        public int calculate(int oldNum, int newNum) {
            return oldNum + newNum;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int calculate(int oldNum, int newNum) {
            return oldNum - newNum;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int calculate(int oldNum, int newNum) {
            return oldNum * newNum;
        }
    },
    DIVISION("/") {
        @Override
        public int calculate(int oldNum, int newNum) {
            return oldNum / newNum;
        }
    };

    String sign;

    OperationType(String sign) {
        this.sign = sign;
    }

    public abstract int calculate(int oldNum, int newNum);

    public static OperationType findType(String operation) {
        for (OperationType type : values()) {
            if (StringUtils.equals(type.sign, operation)) {
                return type;
            }
        }

        throw new RuntimeException("부호 오류 발생");
    }
}
