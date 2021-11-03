package calc.operator;

public class Add implements Operator{
    @Override
    public int operation(int left, int right) {
        return left + right;
    }
}
