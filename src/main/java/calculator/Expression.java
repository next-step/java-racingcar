package calculator;

import com.sun.istack.internal.NotNull;

public class Expression {

    private String mRawExpression;
    private NumberType mNumberType;

    public Expression(@NotNull String rawExpression, NumberType numberType) {
        this.mRawExpression = rawExpression;
        this.mNumberType = numberType;
    }
}
