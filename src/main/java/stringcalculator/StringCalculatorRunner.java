package stringcalculator;

public class StringCalculatorRunner {

    public static int run(String inputText) {
        Expression stringExpression = ExpressionFactory.create(inputText);

        return stringExpression.sumString();
    }
}
