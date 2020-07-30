package step2.core;

import static step2.common.ArithmethicConst.ZERO;

public class DivideArithmetic implements Arithmetic{

    @Override
    public int calculate(int firstVal, int secondVal) {
        if(secondVal == ZERO){
            throw new IllegalArgumentException();
        }
        return firstVal / secondVal;
    }
}
