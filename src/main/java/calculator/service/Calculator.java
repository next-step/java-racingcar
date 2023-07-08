package calculator.service;

import calculator.parser.TextParser;

public final class Calculator {

    private static class CalculatorHolder {
        private static final Calculator INSTANCE = new Calculator();
    }

    private final TextParser textParser;

    private Calculator() {
        this.textParser = TextParser.getInstance();
    }

    public static Calculator getInstance() {
        return CalculatorHolder.INSTANCE;
    }

    public int sum(final String text) {
        return textParser.parse(text)
                         .sum();
    }
}
