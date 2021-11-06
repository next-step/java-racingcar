package calc.operator;

import calc.MyNumber;

public class Divide implements Operator{
    @Override
    public MyNumber execute(MyNumber left, MyNumber right) {
        return left.divide(right);
    }
}
