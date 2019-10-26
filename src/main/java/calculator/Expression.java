package calculator;

import com.sun.istack.internal.NotNull;

public class Expression {

    private static final String SPACE = " ";

    private NumberType mNumberType;

    public Expression(@NotNull String rawExpression, NumberType numberType) {
        this.mNumberType = numberType;
        parse(rawExpression);
    }

    private void parse(String rawExpression) {
        String[] splitedExpression = splitFromSpace(rawExpression);
    }


    private String[] splitFromSpace(@NotNull String text) {
        return text.split(SPACE);
    }
}
