package calc.operator;

public class Multiply implements Operator{
    @Override
    public int operation(int left, int right) {
        return left * right;
    }
}
