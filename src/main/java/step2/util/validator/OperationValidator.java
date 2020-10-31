package step2.util.validator;

import step2.calculator.Operation;

import java.util.List;

public class OperationValidator {
    public static boolean isInvalid(final String symbol) {
        return !isValid(symbol);
    }
    
    public static boolean isValid(final String symbol) {
        final List<String> supportedOperationSymbols = Operation.getSupportedSymbols();
        return supportedOperationSymbols.contains(symbol);
    }
}
