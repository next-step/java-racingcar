package calculator;

public class Minus implements Operable {
    @Override
    public int operate(int leftOp, int rightOp) {
        return leftOp - rightOp;
    }
}
