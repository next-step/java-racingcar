package step2;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVISION("/");

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int calculate(int firstNum, int secondNum) {
        Calculator calculator = new Calculator();
        switch(this) {
            case ADD:
                return calculator.add(firstNum, secondNum);
            case SUBTRACT:
                return calculator.subtract(firstNum, secondNum);
            case MULTIPLY:
                return calculator.multiple(firstNum, secondNum);
            case DIVISION:
                return calculator.divide(firstNum, secondNum);
            default:
                throw new IllegalArgumentException("적절한 연산자가 아닙니다.");
        }
    }
}

