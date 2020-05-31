package calculator;

public enum Calculator {
    ADD {
        public int calculate (int x, int y) {
            return x + y;
        }
    },
    SUBTRACT {
        public int calculate (int x, int y) {
            return x - y;
        }
    },
    MULTIPLY {
        public int calculate (int x, int y) {
            return x * y;
        }
    },
    DIVIDE {
        public int calculate (int x, int y) {
            return x / y;
        }
    };

    public abstract int calculate(int x, int y);
}
