package step2.util.validator;

import step2.util.ExpressionSeparator;

import java.util.List;

public class ExpressionSymbolValidator {
    
    public static boolean isValid(final String expression) {
        return !isInvalid(expression);
    }

    public static boolean isInvalid(final String expression) {
        final List<String> symbols = ExpressionSeparator.split(expression);
        if (symbols.size() == 0) {
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
