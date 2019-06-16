package calculator;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * String Calculator의 Validation 관련 기능
 */
public class Validator {

    void validate(List<String> tokens, IntPredicate predicate, Consumer<String> validationConsumer) {
        IntStream.range(0, tokens.size())
                .filter(predicate)
                .mapToObj(tokens::get)
                .forEach(validationConsumer);
    }

    void validateSizeOf(List<String> tokens) {
        int size = tokens.size();

        if (size < 3 || size % 2 == 0) {
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_ARGUMENT_EXCEPTION_MSG);
        }
    }

    void validateIsNotEmpty(String input) {
        if (null == input || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_ARGUMENT_EXCEPTION_MSG);
        }
    }

    void validateNumber(String stringNumber) {
        try {
            Integer.valueOf(stringNumber);
        } catch (Exception ignored) {
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_ARGUMENT_EXCEPTION_MSG);
        }
    }

    void validateSymbol(String symbol) {
        if(!Symbols.ENABLED_ARITHMETIC_SYMBOLS.contains(symbol)) {
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_ARGUMENT_EXCEPTION_MSG);
        }
    }
}
