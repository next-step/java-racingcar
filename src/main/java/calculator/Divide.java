package calculator;

public class Divide implements Operable {
    @Override
    public int operate(int leftOp, int rightOp) {
        return leftOp / rightOp;
    }
}
