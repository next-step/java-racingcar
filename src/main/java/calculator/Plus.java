package calculator;

public class Plus implements Operable {
    @Override
    public int operate(int leftOp, int rightOp) {
        return leftOp + rightOp;
    }
}
