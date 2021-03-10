package step2;

public enum OperationEnum {

    PLUS("+") {
        @Override
        public int operation(int number1, int number2) {
            return number1 + number2;
        }
    },
    MINUS("-") {
        @Override
        public int operation(int number1, int number2) {
            return number1 - number2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int operation(int number1, int number2) {
            return number1 * number2;
        }
    },
    DIVIDE("/") {
        @Override
        public int operation(int number1, int number2) {
            if (number2 == 0) {
                throw new IllegalArgumentException();
            }
            return number1 / number2;
        }
    },

    NONE("NONE") {
        @Override
        public int operation(int number1, int number2) {
            return 0;
        }
    };

    private final String operator;

    public String getOperator() {
        return operator;
    }

    OperationEnum(String operator) {
        this.operator = operator;
    }

    public abstract int operation(int number1, int number2);

    public static OperationEnum getOperationEnum(String operator) {
        for (OperationEnum value : OperationEnum.values()) {
            if (value.operator.equals(operator)) {
                return value;
            }
        }

        // +, -, *, / 가 아니라면 NONE 반환하기
        return OperationEnum.NONE;
    }
}

