package calculator.parser;

import calculator.model.NonNegativeNumbers;

public final class NumberParser {

    private static class NumberParserHolder {
        private static final NumberParser INSTANCE = new NumberParser();
    }

    private final TextParser textParser;

    private NumberParser() {
        this.textParser = TextParser.getInstance();
    }

    public static NumberParser getInstance() {
        return NumberParserHolder.INSTANCE;
    }

    public NonNegativeNumbers parse(final String text) {
        return NonNegativeNumbers.of(
                textParser.parse(text)
        );
    }
}
