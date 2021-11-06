package calc.operator;

import calc.MyNumber;

public class Minus implements Operator{
    @Override
    public MyNumber execute(MyNumber left, MyNumber right) {
        return left.minus(right);
    }
}
