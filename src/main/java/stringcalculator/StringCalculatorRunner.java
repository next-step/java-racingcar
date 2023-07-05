package stringcalculator;

import stringcalculator.utils.Util;

public class StringCalculatorRunner {

    public static int run(String inputText) {
        StringExpression stringExpression = StringExpressionFactory.create(inputText);

        return Util.sumString(stringExpression.getStringArray());
    }
}
