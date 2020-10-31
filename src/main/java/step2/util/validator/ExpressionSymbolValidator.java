package step2.util.validator;

public class ExpressionSymbolValidator {
    private static final String SEPARATOR = " ";

    public static boolean isValid(final String expression) {
        return !isInvalid(expression);
    }

    public static boolean isInvalid(final String expression) {
        final String[] symbols = expression.split(SEPARATOR);
        if (symbols.length == 0) {
            return true;
        }

        for (final String symbol : symbols) {
            if (isNotExpressionSymbol(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotExpressionSymbol(final String symbol) {
        return OperationValidator.isInvalid(symbol) && IntegerValidator.isInvalid(symbol);
    }
}
