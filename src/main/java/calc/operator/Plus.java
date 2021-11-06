package calc.operator;

import calc.MyNumber;

public class Plus implements Operator{
    @Override
    public MyNumber execute(MyNumber left, MyNumber right) {
        return left.plus(right);
    }
}
