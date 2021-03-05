package step2;

public enum CalculatorType {
    PLUS {
        int calculate(int n1, int n2) {
            return n1 + n2;
        }
    },
    MINUS {
        int calculate(int n1, int n2) {
            return n1 - n2;
        }
    },
    MULTIPLY {
        int calculate(int n1, int n2) {
            return n1 * n2;
        }
    },
    DIVIDE {
        int calculate(int n1, int n2) {
            return n1 / n2;
        }
    };

    abstract int calculate(int n1, int n2);
}
