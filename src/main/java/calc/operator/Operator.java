package calc.operator;

import calc.MyNumber;

public interface Operator {
    MyNumber execute(MyNumber left, MyNumber right);
}
