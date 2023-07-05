package stringcalculator;

public class StringCalculatorRunner {

    public static int run(String inputText) {
        StringExpression stringExpression = StringExpressionFactory.create(inputText);

        return stringExpression.sumString();
    }
}
