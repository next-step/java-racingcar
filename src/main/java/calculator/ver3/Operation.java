package calculator.ver3;

public enum Operation {
    PLUS("+") {
        public MyNumberVer3 apply(MyNumberVer3 x, MyNumberVer3 y) {
            return new MyNumberVer3(x.getNumber() + y.getNumber());
        }
    },
    MINUS("-") {
        public MyNumberVer3 apply(MyNumberVer3 x, MyNumberVer3 y) {
            return new MyNumberVer3(x.getNumber() - y.getNumber());
        }
    },
    MULTIPLE("*") {
        public MyNumberVer3 apply(MyNumberVer3 x, MyNumberVer3 y) {
            return new MyNumberVer3(x.getNumber() * y.getNumber());
        }
    },
    DIVIDE("/") {
        public MyNumberVer3 apply(MyNumberVer3 x, MyNumberVer3 y) {
            valid(y);
            return new MyNumberVer3(x.getNumber() / y.getNumber());
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

    public abstract MyNumberVer3 apply(MyNumberVer3 x, MyNumberVer3 y);

    void valid(MyNumberVer3 other) {
        if (other.getNumber() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
