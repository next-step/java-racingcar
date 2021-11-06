package calc.operator;

import calc.MyNumber;

public class Multiply implements Operator{
    @Override
    public MyNumber execute(MyNumber left, MyNumber right) {
        return left.multiply(right);
    }
}
