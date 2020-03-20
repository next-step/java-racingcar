package calculator;

public class Multiply implements Operable {
    @Override
    public int operate(int leftOp, int rightOp) {
        return leftOp * rightOp;
    }
}
