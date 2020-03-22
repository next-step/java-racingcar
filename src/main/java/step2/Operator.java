package step2;

public enum Operator {
    ADD("+") {
        public int calculate(int firstNum, int secondNum) { return calculator.add(firstNum, secondNum); }
    },
    SUBTRACT("-") {
        public int calculate(int firstNum, int secondNum) {return calculator.subtract(firstNum, secondNum); }
    },
    MULTIPLY("*") {
        public int calculate(int firstNum, int secondNum) {return calculator.multiple(firstNum, secondNum); }
    },
    DIVISION("/") {
        public int calculate(int firstNum, int secondNum) {return calculator.divide(firstNum, secondNum); }
    };

    Calculator calculator = new Calculator();

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract int calculate(int firstNum, int secondNum);

    public static int calculateByOperator(String operator, int firstNum, int secondNum) {
        if(Operator.ADD.getValue().equals(operator)) {
            return Operator.ADD.calculate(firstNum, secondNum);
        }
        else if(Operator.SUBTRACT.getValue().equals(operator)) {
            return Operator.SUBTRACT.calculate(firstNum, secondNum);
        }
        else if(Operator.MULTIPLY.getValue().equals(operator)) {
            return Operator.MULTIPLY.calculate(firstNum, secondNum);
        }
        else if(Operator.DIVISION.getValue().equals(operator)) {
            return Operator.DIVISION.calculate(firstNum, secondNum);
        }
        return -1; // Enum에서 Exception으로 처리해주고 싶은데 어떡하면 좋을까?
    }
}

