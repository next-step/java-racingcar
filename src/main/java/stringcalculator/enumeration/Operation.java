package stringcalculator.enumeration;

public enum Operation {
    ADD("+") {
        @Override
        public int operate(int leftNum, int rightNum) {
            return leftNum + rightNum;
        }
    },
    SUBTRACT("-") {
        @Override
        public int operate(int leftNum, int rightNum) {
            return leftNum - rightNum;
        }
    },
    MULTIPLY("*") {
        @Override
        public int operate(int leftNum, int rightNum) {
            return leftNum * rightNum;
        }
    },
    DIVIDE("/") {
        @Override
        public int operate(int leftNum, int rightNum) {
            return leftNum / rightNum;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    // 문자열 연산자(ex: "+", "-". "*", /)를 매개변수로 받아 그에 맞는 열거형 상수를 반환함.
    public static Operation of(String str) {
        for (Operation operation : values() ) {
             if (operation.symbol.equals(str)) {
                 return operation;
             }
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    public abstract int operate(int leftNum, int rightNum);
}
