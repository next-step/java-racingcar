package calculator;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public Number() {
        this.number = 0;
    }

    protected void changeNumber(int number) {
        this.number = number;
    }

    public static int calculateByOperator(Number x, Number y, Operator operator) {
        int executeResult = operator.execute(x.number, y.number);
        return executeResult;
    }
}
