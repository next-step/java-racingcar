package calc.operator;

public class Subtract implements Operator{
    @Override
    public int operation(int left, int right) {
        return left - right;
    }
}
