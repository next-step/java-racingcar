package step2.domain;

public class OperatedNumber {
    private final int operateResult;
    private final int nextNumber;

    public OperatedNumber(int operateResult, int nextNumber) {
        this.operateResult = operateResult;
        this.nextNumber = nextNumber;
    }

    public int getOperateResult() {
        return operateResult;
    }

    public int getNextNumber() {
        return nextNumber;
    }
}
