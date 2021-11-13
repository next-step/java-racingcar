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

    private static final String ERR_MSG_OPERATION = "사칙연산 기호를 확인하세요";
    private static final String ERR_MSG_DIVIDE_ZERO = "0으로 나눌 수 없습니다.";
    private static final int ZERO = 0;

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public static Operation valueOfString(String text) {
        if (PLUS.symbol.equals(text)) {
            return PLUS;
        }
        if (MINUS.symbol.equals(text)) {
            return MINUS;
        }
        if (MULTIPLE.symbol.equals(text)) {
            return MULTIPLE;
        }
        if (DIVIDE.symbol.equals(text)) {
            return DIVIDE;
        }

        throw new IllegalArgumentException(ERR_MSG_OPERATION);
    }

    public abstract MyNumberVer3 apply(MyNumberVer3 x, MyNumberVer3 y);

    void valid(MyNumberVer3 other) {
        if (other.getNumber() == ZERO) {
            throw new IllegalArgumentException(ERR_MSG_DIVIDE_ZERO);
        }
    }
}
