package step2.calculator.validator;

import step2.calculator.domain.Operation;

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
