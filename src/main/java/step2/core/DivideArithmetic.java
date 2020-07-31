package step2.core;

import static step2.common.ArithmethicConstants.INT_ZERO;

public class DivideArithmetic implements Arithmetic{

    @Override
    public int calculate(int firstVal, int secondVal) {
        if(secondVal == INT_ZERO){
            throw new IllegalArgumentException();
        }
        return firstVal / secondVal;
    }
}
