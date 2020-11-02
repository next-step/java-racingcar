package step2;

public class ComputationalInformation {
    private final int previousValue;
    private final int afterValue;
    private final String operator;

    public ComputationalInformation(int previousValue, int afterValue, String operator) {
        this.previousValue = previousValue;
        this.afterValue = afterValue;
        this.operator = operator;
    }

    public int getPreviousValue() {
        return previousValue;
    }

    public int getAfterValue() {
        return afterValue;
    }

    public String getOperator() {
        return operator;
    }
}
