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
                //Exception 처리??
                return 0;
        }
    }
}

