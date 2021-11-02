package calc.operator;

public class Divide implements Operator{
    @Override
    public int operation(int left, int right) {
        return left / right;
    }
}
