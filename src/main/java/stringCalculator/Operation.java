package stringCalculator;

public enum Operation {

    PLUS {
        @Override
        double calc(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        double calc(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY {
        @Override
        double calc(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        double calc(double x, double y) {
            return x / y;
        }
    };

    abstract double calc(double x, double y);
}
