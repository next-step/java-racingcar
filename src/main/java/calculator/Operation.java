package calculator;

public enum Operation {
    PLUS("+") {
        public MyNumber apply(MyNumber x, MyNumber y) {
            return x.plus(y);
        }
    },
    MINUS("-") {
        public MyNumber apply(MyNumber x, MyNumber y) {
            return x.minus(y);
        }
    },
    MULTIPLE("*") {
        public MyNumber apply(MyNumber x, MyNumber y) {
            return x.multiple(y);
        }
    },
    DIVIDE("/") {
        public MyNumber apply(MyNumber x, MyNumber y) {
            return x.divide(y);
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;

    }


    @Override
    public String toString() {
        return super.toString();
    }

    public abstract MyNumber apply(MyNumber x, MyNumber y);
}
