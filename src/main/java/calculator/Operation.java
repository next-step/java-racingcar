package calculator;

public enum Operation {
    PLUS("+") {
        public MyNumber apply(MyNumber x, MyNumber y) {
            return new MyNumber(x.getNumber() + y.getNumber());
        }
    },
    MINUS("-") {
        public MyNumber apply(MyNumber x, MyNumber y) {
            return new MyNumber(x.getNumber() - y.getNumber());
        }
    },
    MULTIPLE("*") {
        public MyNumber apply(MyNumber x, MyNumber y) {
            return new MyNumber(x.getNumber() * y.getNumber());
        }
    },
    DIVIDE("/") {
        public MyNumber apply(MyNumber x, MyNumber y) {
            return new MyNumber(x.getNumber() / y.getNumber());
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

    public static Operation valueOfString(String text) {
        for (Operation op : Operation.values()) {
            if (op.symbol.equals(text)) {
                return op;
            }
        }
        throw new IllegalArgumentException("사칙연산 기호를 확인하세요");
    }

    public abstract MyNumber apply(MyNumber x, MyNumber y);
}
