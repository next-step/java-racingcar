package calculate;

enum Operate {
    ADD {
        @Override
        int calculate(int left, int right) {
            return left + right;
        }
    },
    SUBTRACT {
        @Override
        int calculate(int left, int right) {
            return left - right;
        }
    },
    MULTIPLY {
        @Override
        int calculate(int left, int right) {
            return left * right;
        }
    },
    DIVIDE {
        @Override
        int calculate(int left, int right) {
            if (right == 0) {
                throw new ArithmeticException("분모 0");
            }
            return left / right;
        }
    };

    abstract int calculate(int left, int right);
}
